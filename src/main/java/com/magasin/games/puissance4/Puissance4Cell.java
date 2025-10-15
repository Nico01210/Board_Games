package com.magasin.games.puissance4;

import com.magasin.model.game.Cell;

public class Puissance4Cell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}
