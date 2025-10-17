package com.magasin.Core;

public abstract class Player {
    protected String name;
    protected char symbol; // symbole pour l'affichage
    /**
     * Constructeur défensif de Player.
     * @param name nom du joueur (non null, non vide)
     * @param symbol symbole du joueur
     * @throws IllegalArgumentException si le nom est null ou vide
     */
    public Player(String name, char symbol) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Le nom du joueur ne peut pas être null ou vide.");
        }
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    /**
     * Méthode abstraite pour obtenir le coup du joueur.
     * @param game le jeu actuel (non null)
     * @return le Move choisi par le joueur
     * @throws NullPointerException si game est null
     */
    public abstract Move getMove(Game game);
}
