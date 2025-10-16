package com.magasin.model.puissance4;

import com.magasin.Core.Game;
import com.magasin.Core.Move;
import com.magasin.Core.ArtificialPlayer;
import com.magasin.Core.Player;

public class Puissance4 extends Game {

    public Puissance4(Player p1, Player p2) {
        super(p1, p2);
        board = new Puissance4Board();
    }
    /**
     * Joue un tour de jeu pour le joueur courant.
     * @param player joueur actif
     * @return true si le coup est valide
     */
    @Override
    public boolean makeMove(Player player, int row, int col) {
        // row est ignoré car on ne peut pas choisir la ligne dans Puissance4
        return ((Puissance4Board) board).dropDisc(col, player);
    }

    /**
     * Exécute un tour complet pour le joueur courant.
     * <p>
     * Selon le jeu, cela peut inclure :
     * - Demander le coup au joueur humain
     * - Calculer le coup de l'IA
     * - Mettre à jour le plateau (placer un jeton, une case, etc.)
     * - Changer le joueur courant
     * </p>
     * <p>
     * Cette méthode est abstraite et doit être implémentée par chaque jeu
     * spécifique (TicTacToe, Puissance4, Gomoku).
     * </p>
     */
    @Override
    public void playOneTurn() {
        int col;
        boolean validMove;

        do {
            Move move = getCurrentPlayer().getMove(this);
            col = move.getCol();  // seule la colonne est utilisée

            validMove = ((Puissance4Board) board).dropDisc(col, getCurrentPlayer());

            if (!validMove && !(getCurrentPlayer() instanceof ArtificialPlayer)) {
                System.out.println("❌ Colonne pleine ou invalide, choisis-en une autre !");
            }

        } while (!validMove && !(getCurrentPlayer() instanceof ArtificialPlayer));
    }
    /**
     * Vérifie si la partie est terminée.
     * <p>
     * Une partie est terminée si :
     * - Un joueur a gagné
     * - Le plateau est plein (égalité)
     * </p>
     *
     * @return true si la partie est terminée, false sinon
     */
    @Override
    public boolean isOver() {
        return getWinner() != null || board.isFull();
    }

    /**
     * Retourne le joueur gagnant de la partie.
     * <p>
     * Cette méthode doit renvoyer :
     * - le joueur qui a remporté la partie
     * - ou null si la partie est encore en cours ou si c'est une égalité
     * </p>
     *
     * @return le joueur gagnant, ou null s'il n'y a pas de gagnant
     */
    @Override
    public Player getWinner() {
        Puissance4Cell[][] cells = ((Puissance4Board) board).cells;

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getCols(); j++) {
                Player p = cells[i][j].getOccupant();
                if (p == null) continue;

                // Horizontal
                if (j + 3 < board.getCols() &&
                        p == cells[i][j+1].getOccupant() &&
                        p == cells[i][j+2].getOccupant() &&
                        p == cells[i][j+3].getOccupant()) return p;

                // Vertical
                if (i + 3 < board.getRows() &&
                        p == cells[i+1][j].getOccupant() &&
                        p == cells[i+2][j].getOccupant() &&
                        p == cells[i+3][j].getOccupant()) return p;

                // Diagonale bas-droite
                if (i + 3 < board.getRows() && j + 3 < board.getCols() &&
                        p == cells[i+1][j+1].getOccupant() &&
                        p == cells[i+2][j+2].getOccupant() &&
                        p == cells[i+3][j+3].getOccupant()) return p;

                // Diagonale bas-gauche
                if (i + 3 < board.getRows() && j - 3 >= 0 &&
                        p == cells[i+1][j-1].getOccupant() &&
                        p == cells[i+2][j-2].getOccupant() &&
                        p == cells[i+3][j-3].getOccupant()) return p;
            }
        }
        return null;
    }
}
