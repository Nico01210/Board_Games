package com.magasin.model.gomoku;

import com.magasin.Core.Cell;

public class GomokuCell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}