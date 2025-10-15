package com.magasin.games.gomoku;

import com.magasin.model.game.Cell;

public class GomokuCell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}