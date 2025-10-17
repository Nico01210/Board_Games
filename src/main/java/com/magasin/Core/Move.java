package com.magasin.Core;

public class Move {
    private int row;
    private int col;

    /**
     * Constructeur défensif de Move.
     * @param row ligne du coup (>= 0, ou -1 pour Puissance4 où seule la colonne compte)
     * @param col colonne du coup (>= 0)
     * @throws IllegalArgumentException si row < -1 ou col < 0
     */
    public Move(int row, int col) {
        if (row < -1 || col < 0) {
            throw new IllegalArgumentException("La ligne doit être >= -1 et la colonne >= 0. Reçu row=" + row + ", col=" + col);
        }
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}
