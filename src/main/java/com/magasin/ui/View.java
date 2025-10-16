package com.magasin.ui;

import com.magasin.Core.Board;
import com.magasin.Core.Game;

public class View {
    public static void displayBoard(Board board) {
        System.out.println("\n┌───┬───┬───┐");
        for (int i = 0; i < board.getRows(); i++) {
            System.out.print("│ ");
            for (int j = 0; j < board.getCols(); j++) {
                String cellContent = board.getCell(i, j).display();
                // Remplacer les espaces vides par des espaces pour une meilleure lisibilité
                if (cellContent.equals(" ")) {
                    cellContent = " ";
                }
                System.out.print(cellContent + " │ ");
            }
            System.out.println();
            
            // Ligne de séparation entre les rangées (sauf après la dernière)
            if (i < board.getRows() - 1) {
                System.out.println("├───┼───┼───┤");
            }
        }
        System.out.println("└───┴───┴───┘\n");
    }
    
    public static void showResult(Game game) {
        if (game.getWinner() != null) {
            displayMessage("Le gagnant est : " + game.getWinner().getName());
        } else {
            displayMessage("Match nul !");
        }
    }
    
    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
