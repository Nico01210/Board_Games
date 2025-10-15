package com.magasin.controller;

import com.magasin.model.game.Game;
import com.magasin.model.player.Player;

/**
 * Contrôleur générique pour tous les jeux.
 * Contient les méthodes communes pour gérer un tour et le déroulement d'une partie.
 */
public abstract class GameController {

    protected Game game;

    public GameController(Game game) {
        this.game = game;
    }

    /**
     * Démarre le jeu et gère le déroulement principal.
     */
    public abstract void startGame();

    /**
     * Gère un tour de jeu pour un joueur donné.
     *
     * @param player le joueur dont c'est le tour
     */
    public abstract void playTurn(Player player);

    /**
     * Vérifie si le jeu est terminé (victoire ou égalité)
     *
     * @return true si la partie est finie
     */
    public boolean isGameOver() {
        return game.isOver();
    }
}
