package com.magasin.controller;

import com.magasin.Core.*;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.ui.View;

public class GameController {
    
    private Game currentGame;
    private GameState state;
    private boolean gameRunning;
    private TicTacToeGameEngine ticTacToeEngine;

    public GameController() {
        this.state = GameState.INITIALIZING;
        this.gameRunning = false;
        this.ticTacToeEngine = new TicTacToeGameEngine(this);
    }

    public void startGame(Game game) {
        try {
            changeState(GameState.CONFIGURING);
            
            if (game == null) {
                throw new IllegalArgumentException("Le jeu ne peut pas être null");
            }
            
            this.currentGame = game;
            this.gameRunning = true;
            
            changeState(GameState.PLAYING);
            
            System.out.println("\n=== Début du jeu : " + game.getClass().getSimpleName() + " ===\n");
            
            Player[] players = game.getPlayers();
            System.out.println("Joueur 1: " + players[0]);
            System.out.println("Joueur 2: " + players[1]);
            System.out.println();
            
            View.displayBoard(game.getBoard());
            
            runGameLoop();
            
        } catch (Exception e) {
            changeState(GameState.ERROR);
            System.err.println("Erreur lors du démarrage: " + e.getMessage());
        }
    }

    private void runGameLoop() {
        while (gameRunning && state.isGameActive()) {
            try {
                processCurrentState();
            } catch (Exception e) {
                System.err.println("Erreur pendant le jeu: " + e.getMessage());
                changeState(GameState.ERROR);
            }
        }
    }

    private void processCurrentState() {
        // Utilisation du pattern Visitor pour déléguer le traitement spécifique
        if (currentGame instanceof com.magasin.model.tictactoe.TicTacToe) {
            state.accept(ticTacToeEngine, (com.magasin.model.tictactoe.TicTacToe) currentGame);
        }
        
        // Traitement générique par état (machine à états classique)
        switch (state) {
            case PLAYING:
                if (!currentGame.isOver()) {
                    changeState(GameState.WAITING_FOR_MOVE);
                } else {
                    changeState(GameState.CHECKING_END_CONDITIONS);
                }
                break;
                
            case WAITING_FOR_MOVE:
                changeState(GameState.VALIDATING_MOVE);
                playOneTurn();
                break;
                
            case VALIDATING_MOVE:
                changeState(GameState.UPDATING_GAME);
                break;
                
            case UPDATING_GAME:
                View.displayBoard(currentGame.getBoard());
                changeState(GameState.CHECKING_END_CONDITIONS);
                break;
                
            case CHECKING_END_CONDITIONS:
                if (checkGameEnd()) {
                    changeState(GameState.GAME_OVER);
                } else {
                    changeState(GameState.PLAYING);
                }
                break;
                
            case GAME_OVER:
                gameRunning = false;
                break;
                
            case ERROR:
                gameRunning = false;
                System.err.println("Le jeu s'est arrêté à cause d'une erreur.");
                break;
                
            default:
                System.err.println("État non géré: " + state);
                changeState(GameState.ERROR);
                break;
        }
    }

    private void changeState(GameState newState) {
        this.state = newState;
    }

    private void playOneTurn() {
        Player currentPlayer = currentGame.getCurrentPlayer();
        System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") joue :");
        
        try {
            currentGame.playOneTurn();
            // Changer de joueur après un mouvement réussi
            currentGame.switchPlayer();
        } catch (IllegalArgumentException e) {
            System.out.println("Mouvement invalide: " + e.getMessage());
            changeState(GameState.WAITING_FOR_MOVE);
        }
    }

    private boolean checkGameEnd() {
        Player winner = currentGame.getWinner();
        
        if (winner != null) {
            System.out.println("🎉 Le gagnant est : " + winner.getName() + " (" + winner.getSymbol() + ")");
            return true;
        } else if (currentGame.isOver()) {
            System.out.println("🤝 Match nul ! Bien joué à tous les deux !");
            return true;
        }
        
        return false;
    }

    public void stopGame() {
        gameRunning = false;
        changeState(GameState.GAME_OVER);
        System.out.println("Partie arrêtée.");
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public GameState getCurrentState() {
        return state;
    }

    public boolean isGameRunning() {
        return gameRunning && state.isGameActive();
    }
}
