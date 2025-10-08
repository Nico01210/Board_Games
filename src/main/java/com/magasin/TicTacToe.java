package com.magasin;



public class TicTacToe {
    //  Taille du plateau
    public static final int SIZE = 3;

    //  Tableau de cellules
    private Cell[][] board;

    // Joueurs actuels
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private View view; // pour afficher
    private InteractionUtilisateur interaction; // interragir avec utilisateur


    // Constructeur : initialise le plateau
    public TicTacToe(Player p1, Player p2, View view, InteractionUtilisateur interaction) {
        this.board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell();
            }
        }
        this.player1 = p1;
        this.player2 = p2;
        this.currentPlayer = player1;

        this.view = view;
        this.interaction = interaction;
    }

    // Place un symbole sur le plateau
    public boolean placeSymbol(int row, int col, String symbol) {
        if (board[row][col].getRepresentation().trim().isEmpty()) {
            board[row][col].setRepresentation(symbol);
            return true;
        }
        return false;
    }

    // Jouer un tour avec le joueur actuel
    public void playOneTurn() {
        currentPlayer.playMove(this); // humain ou IA choisit sa case
        view.displayBoard(board);

        switchPlayer();
    }

    public Cell[][] getBoard() {
        return board;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }


    public Player getCurrentPlayer() {

        return currentPlayer;
    }


    public boolean isOver() {
        if (checkRows() || checkColumns() || checkDiagonals()) {
            return true;
        }
        return isBoardFull();
    }

        // verifie les lignes
        private boolean checkRows() {
            for (int i = 0; i < SIZE; i++) {
                String a = board[i][0].getRepresentation().trim();
                String b = board[i][1].getRepresentation().trim();
                String c = board[i][2].getRepresentation().trim();

                if (!a.isEmpty() && a.equals(b) && b.equals(c)) {
                    System.out.println("Le joueur " + a + " a gagné la partie \uD83C\uDF89 ");
                    return true;
                }
            }
            return false;
        }

        // verifie les colonnes
        private boolean checkColumns() {
            for (int j = 0; j < SIZE; j++) {
                String a = board[0][j].getRepresentation().trim();
                String b = board[1][j].getRepresentation().trim();
                String c = board[2][j].getRepresentation().trim();

                if (!a.isEmpty() && a.equals(b) && b.equals(c)) {
                    System.out.println("Le joueur " + a + " a gagné la partie \uD83C\uDF89 ");
                    return true;
                }
            }
            return false;
        }

        // Vérifie les diagonales
        private boolean checkDiagonals() {

            // diagonale principale
            String first = board[0][0].getRepresentation().trim();
            if (!first.isEmpty()) {
                boolean win = true;
                for (int i = 1; i < SIZE; i++) {
                    if (!board[i][i].getRepresentation().trim().equals(first)) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    view.showMessage("🎉 Le joueur " + first + " a gagné !");
                    return true;
                }
            }

            // Diagonale secondaire
            first = board[0][SIZE - 1].getRepresentation().trim();
            if (!first.isEmpty()) {
                boolean win = true;
                for (int i = 1; i < SIZE; i++) {
                    if (!board[i][SIZE - 1 - i].getRepresentation().trim().equals(first)) {
                        win = false;
                        break;
                    }
                }
                if (win) {
                    view.showMessage("Le joueur " + first + " a gagné la partie \uD83C\uDF89 ");
                    return true;
                }
            }

            return false;
        }
        // verifie si le plateau est plein

        private boolean isBoardFull() {

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j].getRepresentation().trim().isEmpty()) {
                        return false;
                    }
                }
            }
            view.showMessage("Match nul ! Le plateau est plein.");
            return true;
        }

    }


