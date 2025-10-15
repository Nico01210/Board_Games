
package com.magasin.controller;

import com.magasin.model.game.Game;
import com.magasin.model.player.Player;
import com.magasin.ui.View;

    public class GameController {

        // Démarre une partie
        public void startGame(Game game) {
            View.displayBoard(game.getBoard());

            while (!game.isOver()) {
                Player current = game.getCurrentPlayer();
                View.displayMessage(current.getName() + " (" + current.getSymbol() + ") joue :");

                // Le joueur joue son tour
                game.playOneTurn();

                // Affiche le plateau après le coup
                View.displayBoard(game.getBoard());

                // Vérifie s’il y a un gagnant
                Player winner = game.getWinner();
                if (winner != null) {
                    View.displayMessage("🎉 Le gagnant est : " + winner.getName());
                    break;
                }

                // Vérifie si le plateau est plein (match nul)
                if (game.isOver() && winner == null) {
                    View.displayMessage("Match nul !");
                    break;
                }

                // Change de joueur
                game.switchPlayer();
            }
        }
    }

