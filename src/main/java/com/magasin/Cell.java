package com.magasin;


public class Cell {
    private String representation;

    public Cell()
    {
        this.representation = "   "; // 3 espaces par défaut
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = " " + representation + " "; // ajoute des espaces autour pour alignement
    }
}