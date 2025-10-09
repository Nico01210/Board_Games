package com.magasin.TicTacToe;

import com.magasin.Core.Cell;
import com.magasin.Core.Player;

public class TicTacToeCell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}
