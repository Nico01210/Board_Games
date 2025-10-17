package com.magasin.model.tictactoe;

import com.magasin.Core.Game;
import com.magasin.Core.Move;
import com.magasin.Core.Player;

/**
 * Classe représentant le jeu TicTacToe avec machine à états.
 * Hérite de Game pour bénéficier de la logique générique des joueurs.
 */
public class TicTacToe extends Game {

    // --------------------------
    // Attributs
    // --------------------------
    private TicTacToeBoard board;                 // Plateau de jeu
    private final Player player1;                       // Joueur 1
    private final Player player2;                       // Joueur 2

    // --------------------------
    // Constructeur
    // --------------------------
    public TicTacToe(Player p1, Player p2) {
        super(new TicTacToeBoard(), p1, p2);
        if (p1 == null || p2 == null) {
            throw new IllegalArgumentException("Les deux joueurs doivent être non null.");
        }
        this.player1 = p1;
        this.player2 = p2;
        this.board = (TicTacToeBoard) super.board; // Récupérer le board de la classe parente
    }

    // --------------------------
    // Getters et Setters
    // --------------------------
    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public TicTacToeBoard getBoard() { return board; }

    // --------------------------
    // Méthodes héritées de Game
    // --------------------------

    /**
     * Joue un tour complet pour le joueur courant.
     * Ne change pas le joueur courant : c'est géré par le contrôleur.
     */
    @Override
    public void playOneTurn() {
        Player current = getCurrentPlayer();
        if (current == null) {
            throw new IllegalStateException("Le joueur courant ne peut pas être null.");
        }

        Move move = current.getMove(this);
        if (move == null) {
            throw new IllegalStateException("Le joueur n'a pas fourni de coup valide.");
        }

        int row = move.getRow();
        int col = move.getCol();

        if (!isValidCell(row, col)) {
            throw new IndexOutOfBoundsException("Coordonnées hors plateau : (" + row + "," + col + ")");
        }
        // Cast vers TicTacToeCell pour pouvoir setSymbol
        TicTacToeCell cell = (TicTacToeCell) board.getCell(row, col);
        if (!cell.isEmpty()) {
            throw new IllegalStateException("La cellule (" + row + "," + col + ") est déjà occupée.");
        }
        char symbol = getCurrentPlayer() == player1 ? 'X' : 'O';
        cell.setSymbol(symbol);
    }

    /**
     * Tente de jouer un coup pour un joueur donné
     * @param player Joueur actif
     * @param row Ligne
     * @param col Colonne
     * @return true si le coup est valide
     */
    @Override
    public boolean makeMove(Player player, int row, int col) {
        if (player == null) return false;
        if (!isValidCell(row, col)) return false;
        TicTacToeCell cell = (TicTacToeCell) board.getCell(row, col);
        if (cell.isEmpty()) {
            char symbol = player == player1 ? 'X' : 'O';
            cell.setSymbol(symbol);
            return true;
        }
        return false;
    }
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < board.getRows() && col >= 0 && col < board.getCols();
    }
    /**
     * Vérifie si la partie est terminée.
     * @return true si un joueur a gagné ou si le plateau est plein (égalité)
     */
    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    /**
     * Détermine le joueur gagnant.
     * @return le joueur gagnant, ou null si égalité ou partie en cours
     */
    @Override
    public Player getWinner() {
        TicTacToeCell[][] cells = board.getCells();
        int n = board.getRows();

        // Vérifie les lignes et colonnes
        for (int i = 0; i < n; i++) {
            char rowSymbol = cells[i][0].getSymbol();
            boolean rowWin = rowSymbol != ' ';
            for (int j = 1; j < n && rowWin; j++) {
                if (cells[i][j].getSymbol() != rowSymbol) rowWin = false;
            }
            if (rowWin) return rowSymbol == 'X' ? player1 : player2;

            char colSymbol = cells[0][i].getSymbol();
            boolean colWin = colSymbol != ' ';
            for (int j = 1; j < n && colWin; j++) {
                if (cells[j][i].getSymbol() != colSymbol) colWin = false;
            }
            if (colWin) return colSymbol == 'X' ? player1 : player2;
        }

        // Vérifie diagonales
        char diag1 = cells[0][0].getSymbol();
        boolean diag1Win = diag1 != ' ';
        for (int i = 1; i < n && diag1Win; i++) {
            if (cells[i][i].getSymbol() != diag1) diag1Win = false;
        }
        if (diag1Win) return diag1 == 'X' ? player1 : player2;

        char diag2 = cells[0][n - 1].getSymbol();
        boolean diag2Win = diag2 != ' ';
        for (int i = 1; i < n && diag2Win; i++) {
            if (cells[i][n - 1 - i].getSymbol() != diag2) diag2Win = false;
        }
        if (diag2Win) return diag2 == 'X' ? player1 : player2;

        return null; // Aucun gagnant
    }
}
