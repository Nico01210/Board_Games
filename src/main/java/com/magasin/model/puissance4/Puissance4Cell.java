package com.magasin.model.puissance4;

import com.magasin.Core.Cell;

public class Puissance4Cell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}
