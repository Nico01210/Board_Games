package com.magasin.games.tictactoe;

import com.magasin.model.game.Board;
import com.magasin.model.game.Cell;

import java.util.Random;

public class TicTacToeBoard extends Board {
    public TicTacToeCell[][] cells;

    public TicTacToeBoard() {
        super(3, 3);
        cells = new TicTacToeCell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new TicTacToeCell();
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
}
