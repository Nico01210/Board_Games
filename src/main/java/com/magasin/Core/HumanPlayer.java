package com.magasin.Core;

import com.magasin.ui.InteractionUtilisateur;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        return InteractionUtilisateur.askMove(game.getBoard());
    }
}
