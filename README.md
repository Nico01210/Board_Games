# Board_Games 🎲

Board_Games est une bibliothèque de jeux de plateau en Java, permettant de jouer à plusieurs jeux classiques tels que **TicTacToe**, **Puissance 4** et **Gomoku**. Le projet utilise une architecture **MVC** (Modèle-Vue-Contrôleur) pour séparer la logique de jeu, l'affichage et l'interaction utilisateur.

---

## Fonctionnalités

- Gestion de plusieurs jeux de plateau dans un même framework.
- Architecture **MVC** pour une meilleure organisation du code.
- Support pour :
  - **TicTacToe** (3x3)
  - **Puissance 4** (6x7)
  - **Gomoku** (15x15)
- Gestion automatique des tours de jeu entre joueur humain et IA.
- Détection des fins de partie et des gagnants.
- Possibilité d’implémenter facilement de nouveaux jeux grâce aux interfaces et classes abstraites.
- Gestion des exceptions liées aux entrées invalides ou aux coups impossibles.

---

## Structure du projet

src/
└── main/
└── java/
└── com/magasin/
├── core/ # Classes abstraites et interfaces des jeux
├── controller/ # Contrôleurs pour gérer le jeu et les tours
├── model/ # Modèles : plateau, joueurs, coups
└── view/ # Affichage et interaction utilisateur

---

## Architecture

- **Modèle (Model)** : contient la logique du jeu, les plateaux et les joueurs.
- **Vue (View)** : gère l’affichage du plateau et les messages.
- **Contrôleur (Controller)** : orchestre les interactions entre le modèle et la vue, gère les tours de jeu.

---

## Installation

1. Cloner le dépôt :

git clone https://github.com/Nico01210/Board_Games.git
cd Board_Games

Compiler le projet :

javac -d out src/main/java/com/magasin/**/*.java

Lancer un jeu (exemple TicTacToe) :

java -cp out com.magasin.Main

## Utilisation

Chaque jeu implémente des méthodes communes :

playOneTurn() : joue un tour de jeu.

isOver() : indique si la partie est terminée.

getWinner() : retourne le gagnant de la partie.

Les joueurs peuvent être humains ou IA, configurables via le contrôleur.

## Contribution

Contributions bienvenues ! Pour ajouter un nouveau jeu :

Créer une nouvelle classe qui étend la classe abstraite Game.

Implémenter les méthodes playOneTurn(), isOver(), getWinner().

Ajouter une vue spécifique si nécessaire.

Mettre à jour le contrôleur pour inclure le nouveau jeu.

## License

Ce projet est sous licence MIT.

## Contact

Nicolas Perret
Email: nicolas.perret@example.com
GitHub: https://github.com/Nico01210/Board_Games
