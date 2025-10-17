package com.magasin.Core;

import java.util.Scanner;

import com.magasin.model.puissance4.Puissance4;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Constructeur défensif pour HumanPlayer.
     * @param name nom du joueur (non null, non vide)
     * @param symbol symbole du joueur
     */
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move getMove(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Le jeu ne peut pas être null.");
        }
        
        if (game instanceof Puissance4) {
            int col;
            while (true) {
                try {
                    System.out.print("Entrez la colonne (0-" + (game.getBoard().getCols() - 1) + "): ");
                    col = scanner.nextInt();
                    
                    if (col >= 0 && col < game.getBoard().getCols()) {
                        return new Move(-1, col); // row=-1 pour Puissance4
                    } else {
                        System.out.println("❌ Colonne invalide ! Choisissez entre 0 et " + (game.getBoard().getCols() - 1));
                    }
                } catch (Exception e) {
                    System.out.println("❌ Erreur de saisie ! Veuillez entrer un nombre.");
                    scanner.nextLine(); // Vider le buffer
                }
            }
        } else {
            int row, col;
            while (true) {
                try {
                    System.out.print("Entrez la ligne (0-" + (game.getBoard().getRows() - 1) + "): ");
                    row = scanner.nextInt();
                    System.out.print("Entrez la colonne (0-" + (game.getBoard().getCols() - 1) + "): ");
                    col = scanner.nextInt();
                    
                    if (row >= 0 && row < game.getBoard().getRows() && col >= 0 && col < game.getBoard().getCols()) {
                        return new Move(row, col);
                    } else {
                        System.out.println("❌ Coordonnées invalides ! Ligne: 0-" + (game.getBoard().getRows() - 1) + 
                                         ", Colonne: 0-" + (game.getBoard().getCols() - 1));
                    }
                } catch (Exception e) {
                    System.out.println("❌ Erreur de saisie ! Veuillez entrer des nombres.");
                    scanner.nextLine(); // Vider le buffer
                }
            }
        }
    }
}
