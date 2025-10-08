package com.magasin;

public class View {

    // Affiche le plateau
    public void displayBoard(Cell[][] board) {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j].getRepresentation());
                if (j < board[i].length - 1) System.out.print("|");
            }
            System.out.println();
            if (i < board.length - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }

    // Affiche un message générique
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Affiche le gagnant
    public void showWinner(String joueur) {
        System.out.println("🎉 Le joueur " + joueur + " a gagné !");
    }

    // Affiche le match nul
    public void showDraw() {
        System.out.println("Match nul ! Le plateau est plein.");
    }
}
