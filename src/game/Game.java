package game;

import CampusN.DungeonCrawer.Menu;
import cell.Cell;
import personnage.Character;

public class Game {
    private final Menu menu;
    private final Board board;
    private final Dice dice;
    private Character player;
    private int position;

    public Game() {
        this.menu = new Menu();
        this.board = new Board();
        this.dice = new Dice();
        this.position = 1;
    }

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

    private void startGame() {
        if (player == null) {
            menu.info("You must create a character first.");
            return;
        }
        position = 1;
        menu.info("Game started! You are on tile 1/" + board.getSize());
        boolean playing = true;
        while (playing) {
            playTurn();
            if (position >= board.getSize()) {
                menu.info("Bravo ! Tu es arrivé à la fin. Victoire !");
                playing = false;
            }
        }
    }

    private void playTurn() {
        menu.pressEnterToRoll();
        int roll = dice.roll();
        int target = position + roll;
        if (target > board.getSize()) {
            menu.info("Tu dépasses le plateau, tu restes sur place !");
            return;
        }
        menu.info(player.getName() + " avance de " + roll + " cases (" + position + " → " + target + ")");
        position = target;

        Cell currentCell = board.getCell(position);
        menu.info("Tu arrives sur : " + currentCell);
        currentCell.interact(player, menu);
    }
}
