package com.magasin.demo;

import com.magasin.Core.*;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.controller.GameController;
import com.magasin.ui.View;

/**
 * Démonstration du moteur de jeu avec pattern Visitor
 * Cette démo fait jouer deux IA l'une contre l'autre pour montrer
 * le fonctionnement complet de la machine à états et du moteur Visitor
 */
public class VisitorPatternDemo {

    public static void main(String[] args) {
        System.out.println("🚀 DÉMONSTRATION DU PATTERN VISITOR POUR TICTACTOE");
        System.out.println("=" .repeat(60));
        
        // Crée deux IA pour une démonstration automatique
        Player ia1 = new ArtificialPlayer("IA_Alpha", 'X');
        Player ia2 = new ArtificialPlayer("IA_Beta", 'O');

        // Crée le jeu TicTacToe
        Game ticTacToeGame = new TicTacToe(ia1, ia2);

        // Crée le contrôleur avec machine à états et moteur Visitor
        GameController controller = new GameController();

        System.out.println("🎯 Lancement d'une partie IA vs IA...");
        System.out.println("📋 Pattern utilisés :");
        System.out.println("   • State Machine (Machine à états)");
        System.out.println("   • Visitor Pattern (Moteur spécialisé)");
        System.out.println("   • Template Method (Jeux abstraits)");
        System.out.println("   • Strategy Pattern (Types de joueurs)");
        System.out.println();

        // Lancer la démonstration
        controller.startGame(ticTacToeGame);
        
        System.out.println("\n🏁 Démonstration terminée !");
        System.out.println("✅ Le pattern Visitor a permis une logique spécialisée pour TicTacToe");
        System.out.println("✅ La machine à états a géré les transitions");
        System.out.println("✅ Le moteur a traité chaque état de manière spécifique");
    }
}