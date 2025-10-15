package com.magasin.model.game;

public abstract class Board {
    protected int rows;
    protected int cols;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public abstract Cell getCell(int row, int col);
    public abstract boolean isFull();
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
