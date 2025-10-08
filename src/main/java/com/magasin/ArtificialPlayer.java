package com.magasin;
import java.util.Random;

public class ArtificialPlayer extends Player {
    private View view;
    private Random random = new Random();

    public ArtificialPlayer(String representation, View view) {
        super(representation);
        this.view = view;
    }

    @Override
    public void playMove(TicTacToe board) {
        int row, col;
        boolean success;

        do {
            // Choix aléatoire d'une case
            row = random.nextInt(TicTacToe.SIZE);
            col = random.nextInt(TicTacToe.SIZE);
            success = board.placeSymbol(row, col, getSymbol());
        } while (!success);

        view.showMessage("L'IA " + getSymbol() + " a joué en [" + row + "," + col + "]");
    }
}

