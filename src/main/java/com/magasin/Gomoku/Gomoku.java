package com.magasin.Gomoku;

import com.magasin.Core.*;
import com.magasin.Gomoku.GomokuBoard;
import com.magasin.Gomoku.GomokuCell;
import com.magasin.ui.View;

public class Gomoku extends Game {

    public Gomoku(Player p1, Player p2) {
        super(p1, p2);
        board = new GomokuBoard();
    }

    @Override
    public void playOneTurn() {
        Move move = getCurrentPlayer().getMove(this);
        board.getCell(move.getRow(), move.getCol()).setOccupant(getCurrentPlayer());
        switchPlayer();
    }

    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    @Override
    public Player getWinner() {
        GomokuCell[][] cells = ((GomokuBoard) board).cells;
        int n = board.getRows();
        int winLength = 5; // Gomoku

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Player p = cells[i][j].getOccupant();
                if (p == null) continue;

                int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
                for (int[] d : dirs) {
                    int count = 1;
                    int x = i, y = j;
                    for (int k = 1; k < winLength; k++) {
                        x += d[0];
                        y += d[1];
                        if (x < 0 || x >= n || y < 0 || y >= n) break;
                        if (cells[x][y].getOccupant() == p) count++;
                        else break;
                    }
                    if (count == winLength) return p;
                }
            }
        }
        return null;
    }
}