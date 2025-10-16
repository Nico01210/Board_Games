package com.magasin.controller;

public enum GameState implements TicTacToeStateVisitable {
    INITIALIZING("Initialisation") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitInitializingState(game);
        }
    },
    CONFIGURING("Configuration") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitConfiguringState(game);
        }
    },
    PLAYING("En cours") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitPlayingState(game);
        }
    },
    WAITING_FOR_MOVE("En attente d'un mouvement") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitWaitingForMoveState(game);
        }
    },
    VALIDATING_MOVE("Validation du mouvement") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitValidatingMoveState(game);
        }
    },
    UPDATING_GAME("Mise à jour du jeu") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitUpdatingGameState(game);
        }
    },
    CHECKING_END_CONDITIONS("Vérification de fin") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitCheckingEndConditionsState(game);
        }
    },
    GAME_OVER("Jeu terminé") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitGameOverState(game);
        }
    },
    PAUSED("En pause") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitPausedState(game);
        }
    },
    ERROR("Erreur") {
        @Override
        public void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game) {
            visitor.visitErrorState(game);
        }
    };

    private final String description;

    GameState(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean canPlayMove() {
        return this == WAITING_FOR_MOVE;
    }

    public boolean isGameActive() {
        return this == PLAYING || this == WAITING_FOR_MOVE || 
               this == VALIDATING_MOVE || this == UPDATING_GAME || 
               this == CHECKING_END_CONDITIONS;
    }

    public boolean isGameFinished() {
        return this == GAME_OVER;
    }

    @Override
    public String toString() {
        return description;
    }
}
