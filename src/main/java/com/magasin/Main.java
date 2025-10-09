package com.magasin;

import com.magasin.Core.Game;
import com.magasin.Core.Player;
import com.magasin.ui.Menu;
import com.magasin.ui.View;

public class Main {

    public static void main(String[] args) {
        // Choix du jeu et configuration des joueurs
        Game game = Menu.chooseGame();

        System.out.println("\n=== Début du jeu : " + game.getClass().getSimpleName() + " ===\n");

        // Affiche le plateau vide au début
        View.displayBoard(game.getBoard());

        // Boucle principale
        while (!game.isOver()) {
            Player current = game.getCurrentPlayer();

            // Affiche qui joue
            System.out.println(current.getName() + " (" + current.getSymbol() + ") joue :");

            // Le joueur joue son coup
            game.playOneTurn();

            // Affiche le plateau après le coup
            View.displayBoard(game.getBoard());

            // Vérifie immédiatement si quelqu’un a gagné
            Player winner = game.getWinner();
            if (winner != null) {
                System.out.println("🎉 Le gagnant est : " + winner.getName());
                break; // stoppe la boucle
            }

            // Vérifie si le plateau est plein (match nul)
            if (game.isOver()) {
                System.out.println("Match nul !");
                break;
            }

            // Efface l’écran pour le tour suivant (optionnel)
            clearConsole();
        }
    }

    // Méthode pour nettoyer la console
    private static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("\n--------------------------\n");
        }
    }
}
