package com.magasin.model.player;

import java.util.Random;

import com.magasin.games.puissance4.Puissance4Board;
import com.magasin.model.game.Game;
import com.magasin.model.game.Move;

public class ArtificialPlayer extends Player {
    private Random random = new Random();

    public ArtificialPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        Puissance4Board board = (Puissance4Board) game.getBoard();
        int col;

        // Choisir une colonne aléatoire valide
        do {
            col = random.nextInt(board.getCols());
        } while (!board.canDrop(col));

        return new Move(-1, col); // ligne non utilisée
    }
}
