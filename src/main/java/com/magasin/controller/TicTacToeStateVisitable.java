package com.magasin.controller;

/**
 * Interface Visitable qui permet aux états d'accepter un visiteur.
 * Cela fait partie du pattern Visitor pour permettre le double dispatch.
 */
public interface TicTacToeStateVisitable {
    
    /**
     * Accepte un visiteur et délègue le traitement approprié
     * @param visitor Le visiteur qui va traiter cet état
     * @param game Le jeu TicTacToe associé
     */
    void accept(TicTacToeStateVisitor visitor, com.magasin.model.tictactoe.TicTacToe game);
}