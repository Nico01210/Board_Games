package com.magasin.model.tictactoe;

import com.magasin.Core.Cell;

/**
 * Représente une case du TicTacToe avec un symbole 'X', 'O' ou vide.
 */
public class TicTacToeCell extends Cell {

    private char symbol = ' '; // ' ' = vide, 'X' ou 'O'

    /**
     * Retourne le symbole actuel de la case.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Définit le symbole de la case.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Vérifie si la case est vide.
     */
    public boolean isEmpty() {
        return symbol == ' ';
    }

    /**
     * Affiche la case dans la console.
     * Implémentation obligatoire car Cell a une méthode abstraite display().
     */
    @Override
    public String display() {
        return String.valueOf(symbol);
    }
}
