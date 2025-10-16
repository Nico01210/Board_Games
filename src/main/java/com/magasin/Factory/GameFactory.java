package com.magasin.Factory;

import com.magasin.Core.Game;
import com.magasin.Core.Player;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.model.puissance4.Puissance4;
import com.magasin.model.gomoku.Gomoku;
import com.magasin.ui.View;
import com.magasin.Core.HumanPlayer;
import com.magasin.Core.ArtificialPlayer;

import java.util.Scanner;

public class GameFactory {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Crée un jeu selon le choix de l'utilisateur
     */
    public static Game createGameFromUserChoice() {
        View.displayMessage("Choisissez un jeu :");
        View.displayMessage("1 - TicTacToe");
        View.displayMessage("2 - Puissance4");
        View.displayMessage("3 - Gomoku");

        int choix = scanner.nextInt();
        scanner.nextLine(); // consomme le retour à la ligne

        // Crée les joueurs
        Player player1 = createPlayer(1);
        Player player2 = createPlayer(2);

        switch (choix) {
            case 1:
                return new TicTacToe(player1, player2);
            case 2:
                return new Puissance4(player1, player2);
            case 3:
                return new Gomoku(player1, player2);
            default:
                View.displayMessage("Choix invalide. Départ par défaut sur TicTacToe.");
                return new TicTacToe(player1, player2);
        }
    }

    /**
     * Crée un joueur humain ou IA selon le choix utilisateur
     */
    private static Player createPlayer(int numero) {
        View.displayMessage("Quel type pour le joueur " + numero + " ?");
        View.displayMessage("1 - Humain");
        View.displayMessage("2 - IA");

        int type = scanner.nextInt();
        scanner.nextLine(); // consomme le retour à la ligne

        View.displayMessage("Entrez le nom du joueur " + numero + " :");
        String nom = scanner.nextLine();

        char symbol = (numero == 1) ? 'X' : 'O';

        if (type == 2) {
            return new ArtificialPlayer(nom, symbol);
        } else {
            return new HumanPlayer(nom, symbol);
        }
    }
}
