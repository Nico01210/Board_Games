package com.magasin.Puissance4;

import com.magasin.Core.Board;
import com.magasin.Core.Cell;

public class Puissance4Board extends Board {
    protected Puissance4Cell[][] cells;

    public Puissance4Board() {
        super(6, 7); // 6 lignes, 7 colonnes
        cells = new Puissance4Cell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new Puissance4Cell();
    }

    @Override
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    @Override
    public boolean isFull() {
        for (int j = 0; j < cols; j++) {
            if (cells[0][j].isEmpty()) return false; // si une case du haut est libre
        }
        return true;
    }

    public boolean dropDisc(int col, com.magasin.Core.Player player) {
        for (int i = rows - 1; i >= 0; i--) {
            if (cells[i][col].isEmpty()) {
                cells[i][col].setOccupant(player);
                return true;
            }
        }
        return false; // colonne pleine
    }
}
