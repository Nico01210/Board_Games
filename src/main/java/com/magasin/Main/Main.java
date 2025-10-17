package com.magasin.Main;

import com.magasin.Core.*;
import com.magasin.model.tictactoe.TicTacToe;
import com.magasin.model.puissance4.Puissance4;
import com.magasin.model.gomoku.Gomoku;
import com.magasin.controller.GameController;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runInteractiveMenu();
    }
    
    private static void runInteractiveMenu() {
        System.out.println("🎮 BIENVENUE DANS LE CENTRE DE JEUX DE PLATEAU");
        System.out.println("=" .repeat(50));
        
        // Menu de sélection du jeu
        Game selectedGame = chooseGame();
        
        if (selectedGame != null) {
            // Crée le contrôleur avec machine à états
            GameController controller = new GameController();

            // Lancer le jeu sélectionné
            controller.startGame(selectedGame);
        } else {
            System.out.println("👋 Au revoir !");
        }
    }
    
    private static Game chooseGame() {
        while (true) {
            System.out.println("\n📋 MENU PRINCIPAL");
            System.out.println("Choisissez votre jeu :");
            System.out.println("1. 🎯 TicTacToe (3x3)");
            System.out.println("2. 🔴 Puissance 4 (6x7)");
            System.out.println("3. ⚫ Gomoku (15x15)");
            System.out.println("0. 🚪 Quitter");
            System.out.print("\nVotre choix (0-3) : ");
            
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne
                
                switch (choice) {
                    case 1:
                        System.out.println("\n🎯 TicTacToe sélectionné !");
                        return createTicTacToe();
                    case 2:
                        System.out.println("\n🔴 Puissance 4 sélectionné !");
                        return createPuissance4();
                    case 3:
                        System.out.println("\n⚫ Gomoku sélectionné !");
                        return createGomoku();
                    case 0:
                        return null; // Quitter
                    default:
                        System.out.println("❌ Choix invalide ! Veuillez choisir entre 0 et 3.");
                }
            } catch (Exception e) {
                System.out.println("❌ Erreur de saisie ! Veuillez entrer un nombre.");
                scanner.nextLine(); // Vider le buffer
            }
        }
    }
    
    private static Game createTicTacToe() {
        System.out.println("🎯 Configuration TicTacToe");
        Player[] players = choosePlayers();
        return new TicTacToe(players[0], players[1]);
    }
    
    private static Game createPuissance4() {
        System.out.println("🔴 Configuration Puissance 4");
        Player[] players = choosePlayers();
        return new Puissance4(players[0], players[1]);
    }
    
    private static Game createGomoku() {
        System.out.println("⚫ Configuration Gomoku");
        Player[] players = choosePlayers();
        return new Gomoku(players[0], players[1]);
    }
    
    private static Player[] choosePlayers() {
        System.out.println("\n👥 CONFIGURATION DES JOUEURS");
        
        // Joueur 1
        System.out.println("\n🎭 Joueur 1 (X) :");
        Player player1 = createPlayer("Joueur1", 'X');
        
        // Joueur 2
        System.out.println("\n🎭 Joueur 2 (O) :");
        Player player2 = createPlayer("Joueur2", 'O');
        
        return new Player[]{player1, player2};
    }
    
    private static Player createPlayer(String defaultName, char symbol) {
        System.out.println("Choisissez le type :");
        System.out.println("1. 👤 Joueur Humain");
        System.out.println("2. 🤖 Intelligence Artificielle");
        System.out.print("Votre choix (1-2) : ");
        
        try {
            int type = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne
            
            System.out.print("Nom du joueur (défaut: " + defaultName + ") : ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                name = defaultName;
            }
            
            switch (type) {
                case 1:
                    return new HumanPlayer(name, symbol);
                case 2:
                    return new ArtificialPlayer(name, symbol);
                default:
                    System.out.println("❌ Type invalide, création d'une IA par défaut.");
                    return new ArtificialPlayer(name, symbol);
            }
        } catch (Exception e) {
            System.out.println("❌ Erreur de saisie, création d'une IA par défaut.");
            scanner.nextLine(); // Vider le buffer
            return new ArtificialPlayer(defaultName, symbol);
        }
    }
}
