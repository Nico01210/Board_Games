package com.magasin.model.player;

import java.util.Scanner;

import com.magasin.games.puissance4.Puissance4;
import com.magasin.model.game.Game;
import com.magasin.model.game.Move;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        if (game instanceof Puissance4) {
            System.out.print("Entrez la colonne: ");
            int col = scanner.nextInt();
            return new Move(0, col); // ligne ignorée, gérée par dropDisc()
        } else {
            System.out.print("Entrez la ligne: ");
            int row = scanner.nextInt();
            System.out.print("Entrez la colonne: ");
            int col = scanner.nextInt();
            return new Move(row, col);
        }
    }
}
