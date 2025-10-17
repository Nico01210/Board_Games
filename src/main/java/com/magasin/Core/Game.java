package com.magasin.Core;

/**
 * Classe abstraite représentant un jeu de plateau.
 * <p>
 * Elle définit les méthodes de base communes à tous les jeux :
 * gestion du plateau, des joueurs, des tours et de la fin de partie.
 * </p>
 */
public abstract class Game {
    protected Board board;
    protected Player[] players;
    protected int currentPlayerIndex = 0;

    /**
     * Constructeur défensif d'un jeu.
     * @param board   le plateau de jeu (non null)
     * @param player1 premier joueur (non null)
     * @param player2 second joueur (non null, différent de player1)
     * @throws IllegalArgumentException si un argument est invalide
     */
    public Game(Board board, Player player1, Player player2) {
        if (board == null) {
            throw new IllegalArgumentException("Le plateau de jeu (board) ne peut pas être null.");
        }
        if (player1 == null || player2 == null) {
            throw new IllegalArgumentException("Les joueurs ne peuvent pas être null.");
        }
        if (player1 == player2) {
            throw new IllegalArgumentException("Les deux joueurs doivent être des instances distinctes.");
        }
        this.board = board;
        this.players = new Player[]{player1, player2};
    }
    /**
     * Exécute un tour complet pour le joueur courant.
     */
    public abstract void playOneTurn();

    /**
     * Vérifie si la partie est terminée.
     */

    public abstract boolean isOver();

    /**
     * Retourne le joueur gagnant de la partie.
     */
    public abstract Player getWinner();
    public abstract boolean makeMove(Player player, int row, int col);

    public Board getBoard() {
        return board;
    }
    // Méthodes concrètes communes

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }
}
