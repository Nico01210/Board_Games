package com.magasin.ui;

import com.magasin.Core.Game;
import com.magasin.Core.HumanPlayer;
import com.magasin.Core.ArtificialPlayer;
import com.magasin.Core.Player;
import com.magasin.model.gomoku.Gomoku;
import com.magasin.model.puissance4.Puissance4;
import com.magasin.model.tictactoe.TicTacToe;

import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static Game chooseGame() {
        System.out.println("Choisissez un jeu : 1 - TicTacToe | 2 - Puissance4 | 3 - Gomoku");
        int choice = readInt();

        // Création des joueurs
        Player p1 = createPlayer(1);
        Player p2 = createPlayer(2);

        switch (choice) {
            case 1: return new TicTacToe(p1, p2);
            case 2: return new Puissance4(p1, p2);
            case 3: return new Gomoku(p1, p2);
            default:
                System.out.println("Choix invalide, réessayez.");
                return chooseGame();
        }
    }

    private static Player createPlayer(int playerNumber) {
        System.out.print("Joueur " + playerNumber + " est-il un humain ou l'IA ? (h/i) : ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.equals("h")) {
            System.out.print("Nom du joueur " + playerNumber + " : ");
            String name = scanner.nextLine().trim();
            return new HumanPlayer("Nico",'X');
        } else if (type.equals("i")) {
            return new ArtificialPlayer("Machine" + playerNumber, 'O');
        } else {
            System.out.println("Réponse invalide, veuillez entrer 'h' ou 'i'.");
            return createPlayer(playerNumber);
        }
    }

    private static int readInt() {
        while (true) {
            try {
                String line = scanner.nextLine();
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.print("Veuillez entrer un nombre valide : ");
            }
        }
    }
}
