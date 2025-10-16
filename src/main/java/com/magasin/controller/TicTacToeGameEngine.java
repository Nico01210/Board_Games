package com.magasin.controller;

import com.magasin.Core.*;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.ui.View;

/**
 * Moteur de jeu spécifique au TicTacToe utilisant le pattern Visitor.
 * Ce moteur implémente une logique de traitement spécialisée pour chaque état du jeu.
 */
public class TicTacToeGameEngine implements TicTacToeStateVisitor {
    
    private GameController controller;
    private boolean moveProcessed = false;
    private Move lastMove;
    
    public TicTacToeGameEngine(GameController controller) {
        this.controller = controller;
    }
    
    @Override
    public void visitInitializingState(TicTacToe game) {
        System.out.println("🔧 Initialisation du moteur TicTacToe...");
        // Logique spécifique à l'initialisation du TicTacToe
        validateGameSetup(game);
    }
    
    @Override
    public void visitConfiguringState(TicTacToe game) {
        System.out.println("⚙️ Configuration du TicTacToe...");
        // Configuration spécifique au TicTacToe
        setupTicTacToeRules(game);
    }
    
    @Override
    public void visitPlayingState(TicTacToe game) {
        System.out.println("🎮 TicTacToe en cours...");
        // Logique spécifique au jeu TicTacToe
        analyzeGameState(game);
    }
    
    @Override
    public void visitWaitingForMoveState(TicTacToe game) {
        System.out.println("⏳ En attente du mouvement du joueur...");
        // Logique d'attente spécifique au TicTacToe
        Player currentPlayer = game.getCurrentPlayer();
        
        if (currentPlayer instanceof ArtificialPlayer) {
            System.out.println("🤖 L'IA " + currentPlayer.getName() + " réfléchit...");
            // Simulation du temps de réflexion de l'IA
            try {
                Thread.sleep(1000); // 1 seconde de réflexion
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("👤 " + currentPlayer.getName() + ", à votre tour !");
        }
    }
    
    @Override
    public void visitValidatingMoveState(TicTacToe game) {
        System.out.println("✅ Validation du mouvement TicTacToe...");
        // Validation spécifique aux règles du TicTacToe sera gérée par la logique du jeu
        moveProcessed = true;
    }
    
    @Override
    public void visitUpdatingGameState(TicTacToe game) {
        System.out.println("🔄 Mise à jour du plateau TicTacToe...");
        // La mise à jour est déjà faite par playOneTurn() dans Game
        moveProcessed = false;
        lastMove = null;
    }
    
    @Override
    public void visitCheckingEndConditionsState(TicTacToe game) {
        System.out.println("🏁 Vérification des conditions de fin TicTacToe...");
        // Vérification spécifique aux règles de victoire du TicTacToe
        checkTicTacToeWinConditions(game);
    }
    
    @Override
    public void visitGameOverState(TicTacToe game) {
        System.out.println("🎯 Fin de partie TicTacToe !");
        // Traitement de fin spécifique au TicTacToe
        displayTicTacToeResults(game);
    }
    
    @Override
    public void visitPausedState(TicTacToe game) {
        System.out.println("⏸️ TicTacToe en pause...");
        // Logique de pause spécifique
    }
    
    @Override
    public void visitErrorState(TicTacToe game) {
        System.out.println("❌ Erreur dans le moteur TicTacToe !");
        // Gestion d'erreur spécifique
    }
    
    // === Méthodes privées spécifiques au TicTacToe ===
    
    private void validateGameSetup(TicTacToe game) {
        Player[] players = game.getPlayers();
        if (players == null || players.length != 2) {
            throw new IllegalStateException("TicTacToe nécessite exactement 2 joueurs");
        }
        
        // Vérifier que les symboles sont différents
        if (players[0].getSymbol() == players[1].getSymbol()) {
            throw new IllegalStateException("Les joueurs doivent avoir des symboles différents");
        }
    }
    
    private void setupTicTacToeRules(TicTacToe game) {
        // Configuration des règles spécifiques au TicTacToe
        System.out.println("📋 Règles TicTacToe activées : alignement de 3 symboles requis");
    }
    
    private void analyzeGameState(TicTacToe game) {
        // Analyse de l'état actuel du jeu
        int emptyCells = countEmptyCells(game);
        System.out.println("📊 Cases vides restantes : " + emptyCells);
        
        if (emptyCells == 0 && game.getWinner() == null) {
            System.out.println("⚖️ Situation de match nul probable");
        }
    }
    
    private int countEmptyCells(TicTacToe game) {
        int count = 0;
        Board board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j).isEmpty()) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private void checkTicTacToeWinConditions(TicTacToe game) {
        // Vérification des 8 lignes de victoire possibles (3 lignes, 3 colonnes, 2 diagonales)
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println("🏆 Victoire détectée pour " + winner.getName());
        } else if (countEmptyCells(game) == 0) {
            System.out.println("🤝 Match nul détecté");
        }
    }
    
    private void displayTicTacToeResults(TicTacToe game) {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("🎮 RÉSULTATS FINAUX TICTACTOE");
        System.out.println("=".repeat(30));
        
        View.displayBoard(game.getBoard());
        
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println("🏆 VAINQUEUR : " + winner.getName() + " (" + winner.getSymbol() + ")");
        } else {
            System.out.println("🤝 MATCH NUL");
        }
        
        System.out.println("=".repeat(30));
    }
    
    // Getters/Setters pour l'état interne
    public Move getLastMove() {
        return lastMove;
    }
    
    public void setLastMove(Move lastMove) {
        this.lastMove = lastMove;
    }
    
    public boolean isMoveProcessed() {
        return moveProcessed;
    }
}