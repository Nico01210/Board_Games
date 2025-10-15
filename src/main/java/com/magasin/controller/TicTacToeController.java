package com.magasin.controller;

import com.magasin.model.game.Game;
import com.magasin.model.game.Move;
import com.magasin.model.player.Player;
import com.magasin.model.player.ArtificialPlayer;
import com.magasin.ui.View;
import com.magasin.ui.InteractionUtilisateur;

/**
 * Contrôleur spécifique pour le jeu TicTacToe.
 * Gère les tours des joueurs humains et IA.
 */
public class TicTacToeController extends GameController {

    public TicTacToeController(Game game) {
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
        // Affiche le plateau
        View.displayBoard(game.getBoard());

        Move move;

        // Gestion IA / Humain
        if (player instanceof ArtificialPlayer) {
            move = player.getMove(game); // L'IA choisit son coup automatiquement
            System.out.println("La Machine joue : ligne " + move.getRow() + ", colonne " + move.getCol());
        } else {
            move = InteractionUtilisateur.askMove(game.getBoard());
        }

        // Applique le coup
        game.makeMove(player, move.getRow(), move.getCol());
    }
}
