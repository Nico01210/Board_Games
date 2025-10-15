package com.magasin.games.gomoku;

import com.magasin.model.game.Board;
import com.magasin.model.game.Cell;
import com.magasin.model.player.Player;

public class GomokuBoard extends Board {
    protected GomokuCell[][] cells;

    public GomokuBoard() {
        super(15,15);
        cells = new GomokuCell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new GomokuCell();
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
