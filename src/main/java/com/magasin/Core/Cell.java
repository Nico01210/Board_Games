package com.magasin.Core;

public abstract class Cell {
    protected Player occupant;

    public Player getOccupant() {
        return occupant;
    }

    public boolean isEmpty() {
        return occupant == null;
    }

    public void setOccupant(Player player) {
        this.occupant = player;
    }

    public abstract String display();
}
