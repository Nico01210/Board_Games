package com.magasin.games.tictactoe;

import com.magasin.model.game.Board;
import com.magasin.model.game.Cell;

public class TicTacToeBoard extends Board {
    public TicTacToeCell[][] cells;

    public TicTacToeBoard() {
        super(3, 3);
        cells = new TicTacToeCell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new TicTacToeCell();
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
