package com.magasin.model.gomoku;

import com.magasin.Core.Board;
import com.magasin.Core.Cell;
import com.magasin.Core.Player;

import java.util.Random;

public class GomokuBoard extends Board {
    protected GomokuCell[][] cells;

    public GomokuBoard() {
        super(15,15);
        cells = new GomokuCell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new GomokuCell();
    }
    public int[] getRandomAvailableCell() {
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(rows);
            col = random.nextInt(cols);
        } while (!getCell(row, col).isEmpty());
        return new int[]{row, col};
    }

    @Override
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (cells[i][j].isEmpty()) return false;
        return true;
    }
    public boolean placeStone(int row, int col, Player player) {
        if (cells[row][col].isEmpty()) {
            cells[row][col].setOccupant(player);
            return true;
        }
        return false;
    }
}
