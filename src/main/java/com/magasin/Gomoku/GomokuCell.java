package com.magasin.Gomoku;

import com.magasin.Core.Cell;
import com.magasin.Core.Player;

public class GomokuCell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}