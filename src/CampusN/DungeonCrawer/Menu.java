package CampusN.DungeonCrawer;

import java.util.Scanner;

/** entrée et sortie du console. */
public class Menu {
    public enum Option { NEW_CHARACTER, SHOW_CHARACTER, EDIT_CHARACTER, START_GAME, QUIT }

    private final Scanner scanner = new Scanner(System.in);

    public Option mainMenu(boolean hasCharacter) {
        System.out.println("\n===== DUNGEON CRAWLER =====");
        System.out.println("1) New character");
        System.out.println("2) Show character" + (hasCharacter ? "" : " (create one first)"));
        System.out.println("3) Edit character" + (hasCharacter ? "" : " (create one first)"));
        System.out.println("4) Start game" + (hasCharacter ? "" : " (create one first)"));
        System.out.println("5) Quit");
        int choice = askIntInRange("Choose: ", 1, 5);
        return switch (choice) {
            case 1 -> Option.NEW_CHARACTER;
            case 2 -> Option.SHOW_CHARACTER;
            case 3 -> Option.EDIT_CHARACTER;
            case 4 -> Option.START_GAME;
            default -> Option.QUIT;
        };
    }

    public Character createCharacter() {
        System.out.println("\n-- Create character --");
        int type = askIntInRange("Type (1=Warrior, 2=Wizard): ", 1, 2);
        String name = askNonEmpty("Name: ");
        if (type == 1) {
            return new Warrior(name);
        } else {
            return new Wizard(name);
        }
    }

    public Character editCharacter(Character current) {
        if (current == null) {
            info("No character yet.");
            return null;
        }
        System.out.println("\n-- Edit character --");
        System.out.println("1) Rename");
        System.out.println("2) Back");
        int c = askIntInRange("Choose: ", 1, 2);
        if (c == 1) {
            current.setName(askNonEmpty("New name: "));
            info("Name updated.");
        }
        return current;
    }

    public void showCharacter(Character c) {
        if (c == null) {
            info("No character yet.");
        } else {
            System.out.println("\n-- Character --");
            System.out.println(c);
        }
    }

    public void showProgress(int position, int size) {
        System.out.println("Position: " + position + "/" + size);
    }

    public void pressEnterToRoll() {
        System.out.print("Press ENTER to roll the dice...");
        scanner.nextLine();
    }

    public boolean askYesNo(String label) {
        while (true) {
            System.out.print(label + " (y/n): ");
            String s = scanner.nextLine().trim().toLowerCase();
            if (s.equals("y")) return true;
            if (s.equals("n")) return false;
            System.out.println("Please type 'y' or 'n'.");
        }
    }

    public int askIntInRange(String label, int min, int max) {
        while (true) {
            System.out.print(label);
            String s = scanner.nextLine().trim();
            try {
                int val = Integer.parseInt(s);
                if (val >= min && val <= max) return val;
            } catch (NumberFormatException ignored) {}
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }

    public String askNonEmpty(String label) {
        while (true) {
            System.out.print(label);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }

    public void info(String message) {
        System.out.println(message);
    }

    public void goodbye() {
        System.out.println("Goodbye!");
    }
}
