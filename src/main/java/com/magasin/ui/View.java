package com.magasin.ui;

import com.magasin.Core.Board;
import com.magasin.Core.Game;

public class View {
    public static void displayBoard(Board board) {
        int rows = board.getRows();
        int cols = board.getCols();
        
        // Génération de la bordure supérieure
        System.out.print("\n┌");
        for (int j = 0; j < cols; j++) {
            System.out.print("───");
            if (j < cols - 1) {
                System.out.print("┬");
            }
        }
        System.out.println("┐");
        
        // Affichage des lignes du plateau
        for (int i = 0; i < rows; i++) {
            System.out.print("│ ");
            for (int j = 0; j < cols; j++) {
                String cellContent = board.getCell(i, j).display();
                // Remplacer les espaces vides par des espaces pour une meilleure lisibilité
                if (cellContent.equals(" ")) {
                    cellContent = " ";
                }
                System.out.print(cellContent + " │ ");
            }
            System.out.println();
            
            // Ligne de séparation entre les rangées (sauf après la dernière)
            if (i < rows - 1) {
                System.out.print("├");
                for (int j = 0; j < cols; j++) {
                    System.out.print("───");
                    if (j < cols - 1) {
                        System.out.print("┼");
                    }
                }
                System.out.println("┤");
            }
        }
        
        // Génération de la bordure inférieure
        System.out.print("└");
        for (int j = 0; j < cols; j++) {
            System.out.print("───");
            if (j < cols - 1) {
                System.out.print("┴");
            }
        }
        System.out.println("┘\n");
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
