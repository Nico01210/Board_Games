package com.magasin.model.tictactoe;

import com.magasin.Core.Board;
import com.magasin.Core.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeBoard extends Board {

    private TicTacToeCell[][] cells;
    private final Random random = new Random();

    public TicTacToeBoard() {
        super(3, 3);
        cells = new TicTacToeCell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new TicTacToeCell();
            }
        }
    }

    /**
     * Retourne les coordonnées d'une case vide choisie aléatoirement.
     * @return un tableau {row, col} de la case disponible
     */
    public int[] getRandomAvailableCell() {
        List<int[]> availableCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isEmpty()) {
                    availableCells.add(new int[]{i, j});
                }
            }
        }

        if (availableCells.isEmpty()) {
            throw new IllegalStateException("Aucune cellule disponible sur le plateau.");
        }

        return availableCells.get(random.nextInt(availableCells.size()));
    }

    @Override
    public TicTacToeCell getCell(int row, int col) {
        validateCoordinates(row, col);
        return cells[row][col];
    }

    @Override
    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    /**
     * Vérifie que les coordonnées sont valides pour le plateau.
     * @param row ligne à vérifier
     * @param col colonne à vérifier
     */
    private void validateCoordinates(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IllegalArgumentException(
                    "Coordonnées hors plateau : (" + row + ", " + col + ")"
            );
        }
    }

    /**
     * Getter pour l'accès sécurisé au plateau (lecture seule si nécessaire)
     */
    public TicTacToeCell[][] getCells() {
        return cells;
    }
}
