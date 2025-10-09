package com.magasin.Core;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random = new Random();

    public ArtificialPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        Board board = game.getBoard();
        int row, col;
        do {
            row = random.nextInt(board.getRows());
            col = random.nextInt(board.getCols());
        } while (!board.getCell(row, col).isEmpty());
        return new Move(row, col);
    }
}
