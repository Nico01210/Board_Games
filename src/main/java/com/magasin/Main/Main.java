package com.magasin.Main;

import com.magasin.Core.*;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.controller.GameController;
import com.magasin.ui.View;

public class Main {

    public static void main(String[] args) {

        // Crée les joueurs
        Player p1 = new HumanPlayer("Nico", 'X');
        Player p2 = new ArtificialPlayer("LaMachine", 'O');

        // Crée le jeu
        Game selectedGame = new TicTacToe(p1, p2);

        // Crée la vue
        View view = new View();

        // Crée le contrôleur avec machine à états
        GameController controller = new GameController();

        // Lancer le jeu
        controller.startGame(selectedGame);
    }
}
