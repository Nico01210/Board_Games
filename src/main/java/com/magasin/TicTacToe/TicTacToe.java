package com.magasin.TicTacToe;

import com.magasin.Core.*;
import com.magasin.ui.View;

public class TicTacToe extends Game {

    public TicTacToe(Player p1, Player p2) {
        super(p1, p2);
        board = new TicTacToeBoard();
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
        TicTacToeCell[][] cells = ((TicTacToeBoard) board).cells;
        int n = board.getRows();

        // Vérifier lignes et colonnes
        for (int i = 0; i < n; i++) {
            // Ligne
            Player rowPlayer = cells[i][0].getOccupant();
            boolean rowWin = rowPlayer != null;
            for (int j = 1; j < n && rowWin; j++) {
                if (cells[i][j].getOccupant() != rowPlayer) rowWin = false;
            }
            if (rowWin) return rowPlayer;

            // Colonne
            Player colPlayer = cells[0][i].getOccupant();
            boolean colWin = colPlayer != null;
            for (int j = 1; j < n && colWin; j++) {
                if (cells[j][i].getOccupant() != colPlayer) colWin = false;
            }
            if (colWin) return colPlayer;
        }

        // Diagonale principale
        Player diag1 = cells[0][0].getOccupant();
        boolean diag1Win = diag1 != null;
        for (int i = 1; i < n && diag1Win; i++) {
            if (cells[i][i].getOccupant() != diag1) diag1Win = false;
        }
        if (diag1Win) return diag1;

        // Diagonale secondaire
        Player diag2 = cells[0][n - 1].getOccupant();
        boolean diag2Win = diag2 != null;
        for (int i = 1; i < n && diag2Win; i++) {
            if (cells[i][n - 1 - i].getOccupant() != diag2) diag2Win = false;
        }
        if (diag2Win) return diag2;

        return null;
    }
}
