package com.magasin.model.tictactoe;

import com.magasin.model.TicTacToeStateVisitable;
import com.magasin.model.TicTacToeStateVisitor;

/**
 * Enum représentant tous les états possibles d'une partie de TicTacToe.
 * Implémente le pattern Visitor pour notifier le contrôleur.
 */
public enum TicTacToeState implements TicTacToeStateVisitable {
    START,
    PLAYER1_TURN,
    PLAYER2_TURN,
    CHECK_VICTORY,
    END;

    @Override
    public void accept(TicTacToeStateVisitor visitor) {
        visitor.visit(this); // OK, this est bien TicTacToeState
    }
}
