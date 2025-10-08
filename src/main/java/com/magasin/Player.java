package com.magasin;


public abstract class Player {
    private String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    // Chaque joueur doit implémenter comment il joue un coup
    public abstract void playMove(TicTacToe board);

    public String getSymbol() {
    return representation;
    }
}