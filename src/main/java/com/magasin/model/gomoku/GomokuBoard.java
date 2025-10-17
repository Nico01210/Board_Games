package com.magasin.model.gomoku;

import com.magasin.Core.Board;
import com.magasin.Core.Cell;
import com.magasin.Core.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GomokuBoard extends Board {
    protected GomokuCell[][] cells;

    public GomokuBoard() {
        super(15,15);
        cells = new GomokuCell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                cells[i][j] = new GomokuCell();
    }
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
            throw new IllegalStateException("Le plateau est plein, aucune cellule disponible.");
        }

        Random random = new Random();
        return availableCells.get(random.nextInt(availableCells.size()));
    }

    @Override
    public Cell getCell(int row, int col) {
        if (!isValidCell(row, col)) {
            throw new IndexOutOfBoundsException("Coordonnées hors plateau : (" + row + "," + col + ")");
        }
        return cells[row][col];
    }
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }


    @Override
    public boolean isFull() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (cells[i][j].isEmpty()) return false;
        return true;
    }
    public boolean placeStone(int row, int col, Player player) {
        if (cells[row][col].isEmpty()) {
            cells[row][col].setOccupant(player);
            return true;
        }
        return false;
    }
}
