package com.magasin.ui;

import com.magasin.Core.Game;
import com.magasin.Core.HumanPlayer;
import com.magasin.Core.ArtificialPlayer;
import com.magasin.Gomoku.Gomoku;
import com.magasin.Puissance4.Puissance4;
import com.magasin.TicTacToe.TicTacToe;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static Game chooseGame() {
        System.out.println("Choisissez un jeu : 1-TicTacToe 2-Puissance4 3-Gomoku");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consomme la fin de ligne
        switch (choice) {
            case 1: return new TicTacToe(new HumanPlayer("Joueur 1", 'X'), new ArtificialPlayer("La Machine", '0'));
            case 2: return new Puissance4(new HumanPlayer("Joueur 1", 'X'), new ArtificialPlayer("La Machine", '0'));
            case 3: return new Gomoku(new HumanPlayer("Joueur 1", 'X'), new ArtificialPlayer("La Machine", '0'));
            default: return chooseGame();
        }
    }
}


















