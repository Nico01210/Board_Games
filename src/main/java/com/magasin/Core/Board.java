package com.magasin.Core;


/**
 * Classe abstraite représentant un plateau de jeu.
 * <p>
 * Elle définit les caractéristiques de base d’un plateau :
 * son nombre de lignes, de colonnes et les opérations essentielles
 * de lecture et de vérification d’état.
 * </p>
 */
public abstract class Board {
    protected int rows;
    protected int cols;


    /**
     * Constructeur défensif du plateau.
     *
     * @param rows nombre de lignes (> 0)
     * @param cols nombre de colonnes (> 0)
     * @throws IllegalArgumentException si rows ou cols <= 0
     */
    public Board(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Le plateau doit avoir un nombre de lignes et de colonnes supérieur à 0. Reçu : " + rows + "x" + cols);
        }
        this.rows = rows;
        this.cols = cols;
    }
    /**
     * Retourne la cellule à la position donnée.
     *
     * @param row ligne (0 ≤ row < rows)
     * @param col colonne (0 ≤ col < cols)
     * @return la cellule correspondante
     * @throws IllegalArgumentException si les coordonnées sont hors limites
     */
    public abstract Cell getCell(int row, int col);
    public abstract boolean isFull();
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
