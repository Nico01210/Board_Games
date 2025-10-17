package com.magasin.Core;

import java.util.Random;

import com.magasin.model.gomoku.Gomoku;
import com.magasin.model.gomoku.GomokuBoard;
import com.magasin.model.puissance4.Puissance4;
import com.magasin.model.puissance4.Puissance4Board;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.model.tictactoe.TicTacToeBoard;


/**
 * Représente un joueur contrôlé par l'ordinateur (IA).
 * L'IA choisit un coup valide de manière aléatoire selon le type de jeu.
 */
public class ArtificialPlayer extends Player {
    private final Random random = new Random();

    public ArtificialPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Le jeu ne peut pas être null.");
        }
        if (game instanceof Puissance4) {
            Puissance4Board board = (Puissance4Board) game.getBoard();
            if (board == null) {
                throw new IllegalStateException("Le plateau du jeu Puissance4 est null.");
            }
            int col = board.getRandomAvailableColumn(); // méthode spécifique Puissance4
            if (col < 0 || col >= board.getCols()) {
                throw new IllegalStateException("Colonne générée invalide pour Puissance4 : " + col);
            }
            return new Move(-1, col); // ligne inutile pour Puissance4
        } else if (game instanceof TicTacToe) {
            TicTacToeBoard board = (TicTacToeBoard) game.getBoard();
            if (board == null) {
                throw new IllegalStateException("Le plateau du jeu TicTacToe est null.");
            }
            int[] pos = board.getRandomAvailableCell();
            return new Move(pos[0], pos[1]);
        } else if (game instanceof Gomoku) {
            GomokuBoard board = (GomokuBoard) game.getBoard();
            if (board == null) {
                throw new IllegalStateException("Le plateau du jeu Gomoku est null.");
            }
            int[] pos = board.getRandomAvailableCell();
            return new Move(pos[0], pos[1]);
        } else {
            throw new IllegalArgumentException("Type de jeu non supporté pour l'IA");
        }
    }
}
