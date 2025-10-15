package com.magasin.ui;

import com.magasin.model.game.Board;
import com.magasin.model.game.Move;

import java.util.Scanner;

public class InteractionUtilisateur {
    private static final Scanner scanner = new Scanner(System.in);

    public static Move askMove(Board board) {
        int row, col;
        while (true) {
            try {
                System.out.print("Entrez la ligne: ");
                row = Integer.parseInt(scanner.nextLine());
                System.out.print("Entrez la colonne: ");
                col = Integer.parseInt(scanner.nextLine());

                if (row >= 0 && row < board.getRows() && col >= 0 && col < board.getCols()
                        && board.getCell(row, col).isEmpty()) {
                    return new Move(row, col);
                }
                System.out.println("Case invalide ou occupée, réessayez.");
            } catch (NumberFormatException e) {
                System.out.println("Entrez des nombres valides.");
            }
        }
    }
}
