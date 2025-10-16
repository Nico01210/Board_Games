package com.magasin.controller;

import com.magasin.model.tictactoe.TicTacToe;

/**
 * Interface Visitor pour gérer les états spécifiques du TicTacToe.
 * Le pattern Visitor permet de séparer les algorithmes de traitement
 * des structures de données sur lesquelles ils opèrent.
 */
public interface TicTacToeStateVisitor {
    
    /**
     * Visite l'état d'initialisation du TicTacToe
     */
    void visitInitializingState(TicTacToe game);
    
    /**
     * Visite l'état de configuration du TicTacToe
     */
    void visitConfiguringState(TicTacToe game);
    
    /**
     * Visite l'état de jeu en cours
     */
    void visitPlayingState(TicTacToe game);
    
    /**
     * Visite l'état d'attente de mouvement
     */
    void visitWaitingForMoveState(TicTacToe game);
    
    /**
     * Visite l'état de validation de mouvement
     */
    void visitValidatingMoveState(TicTacToe game);
    
    /**
     * Visite l'état de mise à jour du jeu
     */
    void visitUpdatingGameState(TicTacToe game);
    
    /**
     * Visite l'état de vérification des conditions de fin
     */
    void visitCheckingEndConditionsState(TicTacToe game);
    
    /**
     * Visite l'état de fin de jeu
     */
    void visitGameOverState(TicTacToe game);
    
    /**
     * Visite l'état de pause
     */
    void visitPausedState(TicTacToe game);
    
    /**
     * Visite l'état d'erreur
     */
    void visitErrorState(TicTacToe game);
}