package com.magasin;


public class Main {
    public static void main(String[] args) {

        // Création de la vue et de l'interaction utilisateur

        View view = new View();
        InteractionUtilisateur interaction = new InteractionUtilisateur();

        // Création des joueurs

        Player human = new HumanPlayer("X", interaction, view);
        Player ai = new ArtificialPlayer("O", view);
        // On peut aussi tester :
        // Player human2 = new HumanPlayer("O");
        // Player ai2 = new ArtificialPlayer("X");

        // Création du jeu

        TicTacToe game = new TicTacToe(human, ai, view, interaction);

        // Affichage du plateau initial

        view.showMessage("Plateau initial :");
        view.displayBoard(game.getBoard());


        // Boucle principale du jeu

        while (!game.isOver()) {
            game.playOneTurn();
        }
        // Fermeture du scanner

        interaction.fermerScanner();

        view.showMessage("Fin du jeu !");
    }
}

