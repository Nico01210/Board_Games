package com.magasin.games.tictactoe;

import com.magasin.model.game.Game;
import com.magasin.model.game.Move;
import com.magasin.model.player.Player;

public class TicTacToe extends Game {

    public TicTacToe(Player p1, Player p2) {
        super(p1, p2);
        board = new TicTacToeBoard();
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
