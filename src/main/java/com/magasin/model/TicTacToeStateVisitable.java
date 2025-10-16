package com.magasin.model;

import com.magasin.model.TicTacToeStateVisitor;

/**
 * Interface que chaque état de TicTacToe implémente
 * pour accepter un Visitor.
 */
public interface TicTacToeStateVisitable {
    void accept(TicTacToeStateVisitor visitor);
}
