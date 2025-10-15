package com.magasin.games.puissance4;

import com.magasin.model.game.Game;
import com.magasin.model.game.Move;
import com.magasin.model.player.ArtificialPlayer;
import com.magasin.model.player.Player;

public class Puissance4 extends Game {

    public Puissance4(Player p1, Player p2) {
        super(p1, p2);
        board = new Puissance4Board();
    }

    @Override
    public void playOneTurn() {
        int col;
        boolean validMove;

        do {
            Move move = getCurrentPlayer().getMove(this);
            col = move.getCol();  // seule la colonne est utilisée

            validMove = ((Puissance4Board) board).dropDisc(col, getCurrentPlayer());

            if (!validMove && !(getCurrentPlayer() instanceof ArtificialPlayer)) {
                System.out.println("❌ Colonne pleine ou invalide, choisis-en une autre !");
            }

        } while (!validMove && !(getCurrentPlayer() instanceof ArtificialPlayer));
    }

    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    @Override
    public Player getWinner() {
        Puissance4Cell[][] cells = ((Puissance4Board) board).cells;

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Player p = cells[i][j].getOccupant();
                if (p == null) continue;

                // Horizontal
                if (j + 3 < board.getCols() &&
                        p == cells[i][j+1].getOccupant() &&
                        p == cells[i][j+2].getOccupant() &&
                        p == cells[i][j+3].getOccupant()) return p;

                // Vertical
                if (i + 3 < board.getRows() &&
                        p == cells[i+1][j].getOccupant() &&
                        p == cells[i+2][j].getOccupant() &&
                        p == cells[i+3][j].getOccupant()) return p;

                // Diagonale bas-droite
                if (i + 3 < board.getRows() && j + 3 < board.getCols() &&
                        p == cells[i+1][j+1].getOccupant() &&
                        p == cells[i+2][j+2].getOccupant() &&
                        p == cells[i+3][j+3].getOccupant()) return p;

                // Diagonale bas-gauche
                if (i + 3 < board.getRows() && j - 3 >= 0 &&
                        p == cells[i+1][j-1].getOccupant() &&
                        p == cells[i+2][j-2].getOccupant() &&
                        p == cells[i+3][j-3].getOccupant()) return p;
            }
        }
        return null;
    }
}
