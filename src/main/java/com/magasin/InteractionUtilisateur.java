package com.magasin;

import java.util.Scanner;

public class InteractionUtilisateur {
    private Scanner scanner = new Scanner(System.in);

    public int demanderLigne() {
        return demanderCoordonnee("ligne");
    }

    public int demanderColonne() {
        return demanderCoordonnee("colonne");
    }

    private int demanderCoordonnee(String type) {
        int valeur = -1;
        boolean valide = false;

        while (!valide) {
            System.out.print("Entrez le numéro de " + type + " (0-2) : ");
            if (scanner.hasNextInt()) {
                valeur = scanner.nextInt();
                if (valeur >= 0 && valeur <= 2) {
                    valide = true;
                } else {
                    System.out.println("⚠️ Veuillez entrer un entier entre 0 et 2.");
                }
            } else {
                System.out.println("⚠️ Veuillez entrer un entier valide !");
                scanner.next(); // consomme l'entrée invalide
            }
        }

        return valeur;
    }

    public void fermerScanner() {
        scanner.close();
    }
}
