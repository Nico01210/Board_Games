package com.magasin.Core;

import java.util.Random;

import com.magasin.model.gomoku.Gomoku;
import com.magasin.model.gomoku.GomokuBoard;
import com.magasin.model.puissance4.Puissance4;
import com.magasin.model.puissance4.Puissance4Board;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.model.tictactoe.TicTacToeBoard;

public class ArtificialPlayer extends Player {
    private Random random = new Random();

    public ArtificialPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        if (game instanceof Puissance4) {
            Puissance4Board board = (Puissance4Board) game.getBoard();
            int col = board.getRandomAvailableColumn(); // méthode spécifique Puissance4
            return new Move(-1, col); // ligne inutile pour Puissance4
        } else if (game instanceof TicTacToe) {
            TicTacToeBoard board = (TicTacToeBoard) game.getBoard();
            int[] pos = board.getRandomAvailableCell();
            return new Move(pos[0], pos[1]);
        } else if (game instanceof Gomoku) {
            GomokuBoard board = (GomokuBoard) game.getBoard();
            int[] pos = board.getRandomAvailableCell();
            return new Move(pos[0], pos[1]);
        } else {
            throw new IllegalArgumentException("Type de jeu non supporté pour l'IA");
        }
    }
}
