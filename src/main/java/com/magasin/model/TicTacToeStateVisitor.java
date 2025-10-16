package com.magasin.model;
import com.magasin.model.tictactoe.TicTacToeState;



public interface TicTacToeStateVisitor {
    void visit(TicTacToeState state);
}
