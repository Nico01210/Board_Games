package com.magasin.games.tictactoe;

import com.magasin.model.game.Cell;

public class TicTacToeCell extends Cell {
    @Override
    public String display() {
        return isEmpty() ? "." : String.valueOf(occupant.getSymbol());
    }
}
