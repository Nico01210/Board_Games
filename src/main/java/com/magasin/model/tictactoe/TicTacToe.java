package com.magasin.model.tictactoe;

import com.magasin.Core.Game;
import com.magasin.Core.Move;
import com.magasin.Core.Player;

/**
 * Classe représentant le jeu TicTacToe avec machine à états.
 */
public class TicTacToe extends Game {

    private TicTacToeBoard board;
    private TicTacToeState currentState = TicTacToeState.START;
    private Player player1;
    private Player player2;

    public TicTacToe(Player p1, Player p2) {
        super(p1, p2);
        this.player1 = p1;
        this.player2 = p2;
        this.board = new TicTacToeBoard();
        super.board = this.board; // Assigner le board à la classe parente
    }

    // -------------------------- Getters et Setters --------------------------
    public TicTacToeState getCurrentState() { return currentState; }
    public void setCurrentState(TicTacToeState state) { this.currentState = state; }
    public Player getPlayer1() { return player1; }
    public Player getPlayer2() { return player2; }
    public TicTacToeBoard getBoard() { return board; }

    // -------------------------- Méthodes héritées de Game --------------------------

    @Override
    public void playOneTurn() {
        Move move = getCurrentPlayer().getMove(this);
        int row = move.getRow();
        int col = move.getCol();

        TicTacToeCell cell = (TicTacToeCell) board.getCell(row, col);
        char symbol = getCurrentPlayer() == player1 ? 'X' : 'O';
        cell.setSymbol(symbol);

        // Ne pas faire switchPlayer() ici - sera géré par GameController
    }

    @Override
    public boolean makeMove(Player player, int row, int col) {
        TicTacToeCell cell = (TicTacToeCell) board.getCell(row, col);
        if (cell.isEmpty()) {
            char symbol = player == player1 ? 'X' : 'O';
            cell.setSymbol(symbol);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    @Override
    public Player getWinner() {
        TicTacToeCell[][] cells = board.getCells();
        int n = board.getRows();

        // Vérifie lignes et colonnes
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

        // Diagonales
        char diag1 = cells[0][0].getSymbol();
        boolean diag1Win = diag1 != ' ';
        for (int i = 1; i < n && diag1Win; i++) {
            if (cells[i][i].getSymbol() != diag1) diag1Win = false;
        }
        if (diag1Win) return diag1 == 'X' ? player1 : player2;

        char diag2 = cells[0][n-1].getSymbol();
        boolean diag2Win = diag2 != ' ';
        for (int i = 1; i < n && diag2Win; i++) {
            if (cells[i][n-1-i].getSymbol() != diag2) diag2Win = false;
        }
        if (diag2Win) return diag2 == 'X' ? player1 : player2;

        return null;
    }
}
