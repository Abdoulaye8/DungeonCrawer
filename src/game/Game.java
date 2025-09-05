package game;

import campusnum.Menu;
import campusnum.PersonnageHorsPlateauException;
import cell.Cell;
import personnage.Character;

/**
 * Classe principale de gestion du jeu.
 * Elle orchestre la boucle de jeu, le déplacement du joueur sur le plateau,
 * et les interactions avec les cellules.
 */
public class Game {
    private final Menu menu;
    private final Board board;
    private final Dice dice;
    private Character player;
    private int position;

    /**
     * Crée une nouvelle instance du jeu avec un menu, un plateau et un dé.
     */
    public Game() {
        this.menu = new Menu();
        this.board = new Board();
        this.dice = new Dice();
        this.position = 1;
    }

    /**
     * Lance la boucle principale du jeu (menu principal).
     * Permet de créer/afficher/éditer un personnage et de démarrer la partie.
     */
    public void run() {
        boolean running = true;
        while (running) {
            Menu.Option choice = menu.mainMenu(player != null);
            switch (choice) {
                case NEW_CHARACTER -> player = menu.createCharacter();
                case SHOW_CHARACTER -> menu.showCharacter(player);
                case EDIT_CHARACTER -> player = menu.editCharacter(player);
                case START_GAME -> startGame();
                case QUIT -> running = false;
            }
        }
        menu.goodbye();
    }

    /**
     * Démarre une partie avec le personnage courant et exécute la boucle de jeu.
     * Gère les exceptions si le joueur sort du plateau.
     */
    private void startGame() {
        if (player == null) {
            menu.info("You must create a character first.");
            return;
        }
        position = 1;
        menu.info("Game started! You are on tile 1/" + board.getSize());
        boolean playing = true;
        while (playing) {
            try {
                playTurn();
            } catch (PersonnageHorsPlateauException e) {
                menu.info("Erreur : " + e.getMessage());
                menu.info("Tu restes sur la case " + position + ".");
            }

            if (position >= board.getSize()) {
                menu.info("Bravo ! Tu es arrivé à la fin. Victoire !");
                playing = false;
            }
        }
    }

    /**
     * Joue un tour de jeu : lance le dé, déplace le joueur,
     * et déclenche l'interaction avec la cellule atteinte.
     * @throws PersonnageHorsPlateauException si le déplacement dépasse la taille du plateau
     */
    private void playTurn() throws PersonnageHorsPlateauException {
        menu.pressEnterToRoll();
        int roll = dice.roll();
        int target = position + roll;

        if (target > board.getSize()) {
            throw new PersonnageHorsPlateauException(
                    "Le personnage sort du plateau (cible=" + target + ")"
            );
        }

        menu.info(player.getName() + " avance de " + roll + " cases (" + position + " → " + target + ")");
        position = target;

        Cell currentCell = board.getCell(position);
        menu.info("Tu arrives sur : " + currentCell);
        currentCell.interact(player, menu);
    }
}
