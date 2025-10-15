package com.magasin.controller;

import com.magasin.model.game.Game;
import com.magasin.model.game.Move;
import com.magasin.model.player.ArtificialPlayer;
import com.magasin.model.player.Player;
import com.magasin.ui.View;
import com.magasin.ui.InteractionUtilisateur;

/**
 * Contrôleur spécifique pour le jeu Puissance4.
 */
public class Puissance4Controller extends GameController {

    public Puissance4Controller(Game game) {
        super(game);
    }

    @Override
    public void startGame() {
        // Boucle principale du jeu
        while (!game.isOver()) {
            Player current = game.getCurrentPlayer();
            playTurn(current);
            game.switchPlayer();
        }

        // Affichage du plateau final et du résultat
        View.displayBoard(game.getBoard());
        View.showResult(game);
    }

    @Override
    public void playTurn(Player player) {
        View.displayBoard(game.getBoard());

        Move move;

        if (player instanceof ArtificialPlayer) {
            // L'IA choisit son coup automatiquement
            move = player.getMove(game);
            System.out.println("La Machine joue : colonne " + move.getCol());
        } else {
            // Humain
            move = InteractionUtilisateur.askMove(game.getBoard());
        }

        // Applique le coup
        game.makeMove(player, move.getRow(), move.getCol());
    }

}
