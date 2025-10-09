package com.magasin;

import com.magasin.Core.Game;
import com.magasin.Core.Player;
import com.magasin.ui.Menu;
import com.magasin.ui.View;

public class Main {
    public static void main(String[] args) {
        // Choix du jeu
        Game game = Menu.chooseGame();

        System.out.println("Début du jeu : " + game.getClass().getSimpleName());

        // Boucle principale du jeu
        while (!game.isOver()) {
            Player current = game.getCurrentPlayer();
            System.out.println(current.getName() + " (" + current.getSymbol() + ") joue :");

            View.displayBoard(game.getBoard());  // <-- affiche le plateau avant le tour

            game.playOneTurn();  // le joueur fait son coup

            clearConsole();  // <-- efface l’écran pour plus de lisibilité
        }

        // Affiche le plateau final
        View.displayBoard(game.getBoard());

        // Affiche le résultat
        if (game.getWinner() != null) {
            System.out.println("Le gagnant est : " + game.getWinner().getName());
        } else {
            System.out.println("Match nul !");
        }
    }

    // ✅ Méthode utilitaire manquante
    private static void clearConsole() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            System.out.println("\n--------------------------\n");
        }
    }
}
