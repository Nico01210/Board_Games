package com.magasin.Main;

import com.magasin.games.gomoku.Gomoku;
import com.magasin.games.puissance4.Puissance4;
import com.magasin.games.tictactoe.TicTacToe;
import com.magasin.model.game.Game;
import com.magasin.controller.GameController;
import com.magasin.controller.TicTacToeController;
import com.magasin.controller.GomokuController;
import com.magasin.controller.Puissance4Controller;
import com.magasin.Factory.GameFactory;
import com.magasin.ui.View;

public class Main {

    public static void main(String[] args) {
        try {
            // Demande à l'utilisateur de choisir le jeu et crée-le via la factory
            Game selectedGame = GameFactory.createGameFromUserChoice();

            // Crée le contrôleur correspondant au jeu sélectionné
            GameController controller;

            if (selectedGame instanceof TicTacToe) {
                controller = new TicTacToeController(selectedGame);
            } else if (selectedGame instanceof Gomoku) {
                controller = new GomokuController(selectedGame);
            } else if (selectedGame instanceof Puissance4) {
                controller = new Puissance4Controller(selectedGame);
            } else {
                throw new IllegalArgumentException("Jeu non supporté !");
            }

            // Affiche un message de bienvenue
            View.displayMessage("\n=== Début du jeu : " + selectedGame.getClass().getSimpleName() + " ===\n");

            // Démarre la partie via le contrôleur
            controller.startGame();

        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage de l'application : " + e.getMessage());
            e.printStackTrace();  // pour debug
        } finally {
            View.displayMessage("\nMerci d'avoir joué ! À bientôt !");
        }
    }
}
