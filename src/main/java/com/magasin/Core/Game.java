package com.magasin.Core;

public abstract class Game {
    protected Board board;
    protected Player[] players;
    protected int currentPlayerIndex = 0;

    public Game(Player player1, Player player2) {
        this.players = new Player[]{player1, player2};
    }

    public abstract void playOneTurn();
    public abstract boolean isOver();
    public abstract Player getWinner();

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    protected void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }
}
