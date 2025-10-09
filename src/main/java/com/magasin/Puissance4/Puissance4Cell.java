package com.magasin.Puissance4;

import com.magasin.Core.Cell;
import com.magasin.Core.Player;

public class Puissance4Cell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}
