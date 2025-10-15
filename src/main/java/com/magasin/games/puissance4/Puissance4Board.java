package com.magasin.games.puissance4;

import com.magasin.model.game.Board;
import com.magasin.model.game.Cell;
import com.magasin.model.player.Player;

import java.util.Random;

public class Puissance4Board extends Board {
    protected Puissance4Cell[][] cells;

    public Puissance4Board() {
        super(6, 7); // 6 lignes, 7 colonnes
        cells = new Puissance4Cell[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new Puissance4Cell();
    }
    public int getRandomAvailableColumn() {
        Random random = new Random();
        int col;
        do {
            col = random.nextInt(cols);
        } while (!canDrop(col));
        return col;
    }
    @Override
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    @Override
    public boolean isFull() {
        for (int j = 0; j < cols; j++)
            if (cells[0][j].isEmpty()) return false;
        return true;
    }

    // Dépose un jeton du joueur dans la colonne
    public boolean dropDisc(int col, Player player) {
        for (int i = rows - 1; i >= 0; i--) {
            if (cells[i][col].isEmpty()) {
                cells[i][col].setOccupant(player);
                return true;
            }
        }
        return false; // colonne pleine
    }

    // Vérifie si une colonne est jouable
    public boolean canDrop(int col) {
        return col >= 0 && col < cols && cells[0][col].isEmpty();
    }
}
