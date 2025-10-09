package com.magasin.ui;

import com.magasin.Core.Board;
import com.magasin.Core.Cell;

public class View {
    public static void displayBoard(Board board) {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                System.out.print(board.getCell(i, j).display() + " ");
            }
            System.out.println();
        }
    }
}
