package com.magasin.model.player;

import com.magasin.model.game.Game;
import com.magasin.model.game.Move;

public abstract class Player {
    protected String name;
    protected char symbol; // symbole pour l'affichage

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract Move getMove(Game game);
}
