package com.magasin.model.game;

import com.magasin.model.player.Player;

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

    public Game(Player player1, Player player2) {
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

    public void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }
}
