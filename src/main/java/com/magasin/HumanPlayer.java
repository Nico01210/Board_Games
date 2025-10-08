package com.magasin;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private InteractionUtilisateur interaction;
    private View view;

    public HumanPlayer(String representation, InteractionUtilisateur interaction, View view) {
        super(representation);
        this.interaction = interaction;
        this.view = view;
    }

    @Override
    public void playMove(TicTacToe board) {
        int row, col;
        boolean success;

        do {
            view.showMessage("Tour du joueur " + getSymbol());
            row = interaction.demanderLigne();
            col = interaction.demanderColonne();
            success = board.placeSymbol(row, col, getSymbol());
            if (!success) {
                view.showMessage("❌ Case déjà occupée, veuillez réessayer !");
            }
        } while (!success);
    }
}
