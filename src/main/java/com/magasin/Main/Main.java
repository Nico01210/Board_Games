package com.magasin.Main;

import com.magasin.model.game.Game;
import com.magasin.controller.GameController;
import com.magasin.Factory.GameFactory;
import com.magasin.ui.View;

public class Main {

    public static void main(String[] args) {
        try {
            // Crée le contrôleur
            GameController controller = new GameController();

            // Demande à l'utilisateur de choisir le jeu et crée-le via la factory
            Game selectedGame = GameFactory.createGameFromUserChoice();

            // Affiche un message de bienvenue
            View.displayMessage("\n=== Début du jeu : " + selectedGame.getClass().getSimpleName() + " ===\n");

            // Démarre la partie via le contrôleur
            controller.startGame(selectedGame);

        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage de l'application : " + e.getMessage());
            e.printStackTrace();  // pour debug, ou remplacer par un logger plus tard
        } finally {
            View.displayMessage("\nMerci d'avoir joué ! À bientôt !");
        }
    }
}
