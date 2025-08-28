package CampusN.DungeonCrawer;


    /** Control du jeux. */
    public class Game {
        private final Menu menu;
        private final Board board;
        private final Dice dice;
        private Character player; // null until created
        private int position; // 1..board.size

        public Game() {
            this.menu = new Menu();
            this.board = new Board(64);
            this.dice = new Dice();
            this.position = 1; // starting tile
        }

        /** Main pour vu: menu -> actions -> quit. */
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
            position = 1; // reset
            menu.info("Game started! You are on tile 1/" + board.getSize());
            boolean playing = true;
            while (playing) {
                menu.pressEnterToRoll();
                int roll = dice.roll();
                int target = position + roll;
                try {
                    if (target > board.getSize()) {
                        throw new PersonnageHorsPlateauException(" Position " + target + " dépasse le plateau !");
                    }
                    menu.info(player.getName() + " rolls " + roll + " and moves from "
                            + position + " to " + target + ".");
                    position = target;
                } catch (PersonnageHorsPlateauException e) {
                    menu.info(e.getMessage());
                    position = board.getSize(); // Forcer la fin
                }
                menu.showProgress(position, board.getSize());
                if (position >= board.getSize()) {
                    menu.info(" welldone! tu es arrivé à la fin! You win.");
                    playing = false;
                    if (menu.askYesNo("Play again?")) {
                        position = 1;
                    }
                }
            }
        }

    }

