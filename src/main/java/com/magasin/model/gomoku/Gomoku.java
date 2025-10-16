package com.magasin.model.gomoku;

import com.magasin.Core.Game;
import com.magasin.Core.Move;
import com.magasin.Core.Player;

public class Gomoku extends Game {

    public Gomoku(Player p1, Player p2) {
        super(p1, p2);
        board = new GomokuBoard();
    }
    /**
     * Exécute un tour complet pour le joueur courant.
     * <p>
     * Selon le jeu, cela peut inclure :
     * - Demander le coup au joueur humain
     * - Calculer le coup de l'IA
     * - Mettre à jour le plateau (placer un jeton, une case, etc.)
     * - Changer le joueur courant
     * </p>
     * <p>
     * Cette méthode est abstraite et doit être implémentée par chaque jeu
     * spécifique (TicTacToe, Puissance4, Gomoku).
     * </p>
     */
    @Override
    public void playOneTurn() {
        Move move = getCurrentPlayer().getMove(this);
        board.getCell(move.getRow(), move.getCol()).setOccupant(getCurrentPlayer());
        switchPlayer();
    }

    /**
     * Joue un tour de jeu pour le joueur courant.
     * @param player joueur actif
     * @return true si le coup est valide
     */
    @Override
    public boolean makeMove(Player player, int row, int col) {
        if (board.getCell(row, col).isEmpty()) {
            board.getCell(row, col).setOccupant(player);
            return true;
        }
        return false;
    }
    /**
     * Vérifie si la partie est terminée.
     * <p>
     * Une partie est terminée si :
     * - Un joueur a gagné
     * - Le plateau est plein (égalité)
     * </p>
     *
     * @return true si la partie est terminée, false sinon
     */
    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }
    /**
     * Retourne le joueur gagnant de la partie.
     * <p>
     * Cette méthode doit renvoyer :
     * - le joueur qui a remporté la partie
     * - ou null si la partie est encore en cours ou si c'est une égalité
     * </p>
     *
     * @return le joueur gagnant, ou null s'il n'y a pas de gagnant
     */
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