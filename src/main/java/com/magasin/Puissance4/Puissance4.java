package com.magasin.Puissance4;

import com.magasin.Core.*;
import com.magasin.ui.View;

public class Puissance4 extends Game {

    public Puissance4(Player p1, Player p2) {
        super(p1, p2);
        board = new Puissance4Board();
    }

    @Override
    public void playOneTurn() {
        int col;
        do {
            col = getCurrentPlayer().getMove(this).getCol();
        } while (!((Puissance4Board) board).dropDisc(col, getCurrentPlayer()));
        switchPlayer();
    }

    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    @Override
    public Player getWinner() {
        Puissance4Cell[][] cells = ((Puissance4Board) board).cells;

        // Vérifier 4 alignés : horizontal, vertical, diagonales
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Player p = cells[i][j].getOccupant();
                if (p == null) continue;

                // horizontal
                if (j + 3 < board.getCols() &&
                        p == cells[i][j+1].getOccupant() &&
                        p == cells[i][j+2].getOccupant() &&
                        p == cells[i][j+3].getOccupant()) return p;

                // vertical
                if (i + 3 < board.getRows() &&
                        p == cells[i+1][j].getOccupant() &&
                        p == cells[i+2][j].getOccupant() &&
                        p == cells[i+3][j].getOccupant()) return p;

                // diagonale bas-droite
                if (i + 3 < board.getRows() && j + 3 < board.getCols() &&
                        p == cells[i+1][j+1].getOccupant() &&
                        p == cells[i+2][j+2].getOccupant() &&
                        p == cells[i+3][j+3].getOccupant()) return p;

                // diagonale bas-gauche
                if (i + 3 < board.getRows() && j - 3 >= 0 &&
                        p == cells[i+1][j-1].getOccupant() &&
                        p == cells[i+2][j-2].getOccupant() &&
                        p == cells[i+3][j-3].getOccupant()) return p;
            }
        }

        return null;
    }
}
