package campusnum;

import personnage.Character;
import personnage.Warrior;
import personnage.Wizard;

import java.util.Scanner;

/**
 * Classe responsable de la saisie et de l'affichage console.
 * Elle Fournit un menu principal et des utilitaires de saisie réutilisables.
 **/
public class Menu {
    /** Options du menu principal. */
    public enum Option { NEW_CHARACTER, SHOW_CHARACTER, EDIT_CHARACTER, START_GAME, QUIT }

    private final Scanner scanner = new Scanner(System.in);
    /**
     * Affiche le menu principal et lit le choix utilisateur.
     * @param hasCharacter {@code true} si un personnage a déjà été créé
     * @return l'option choisie
     */

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

    /**
     * Crée un personnage (Warrior ou Wizard) via la console.
     * @return instance de {@link personnage.Character}
     */
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

    /**
     * Edite un personnage existant (actuellement supporte seulement le renommage).
     * @param current personnage à éditer, peut être {@code null}
     * @return le personnage modifié ou {@code null}
     */
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

    /**
     * Affiche le personnage sur la console.
     * @param c personnage à afficher (peut être {@code null})
     */
    public void showCharacter(Character c) {
        if (c == null) {
            info("No character yet.");
        } else {
            System.out.println("\n-- Character --");
            System.out.println(c);
        }
    }
    /**
     * Affiche la progression sur le plateau.
     * @param position position courante (1-based)
     * @param size     taille du plateau
     */
    public void showProgress(int position, int size) {
        System.out.println("Position: " + position + "/" + size);
    }
    /** Invite l'utilisateur à appuyer sur ENTRÉE pour lancer le dé. */
    public void pressEnterToRoll() {
        System.out.print("Press ENTER to roll the dice...");
        scanner.nextLine();
    }

    /**
     * Pose une question oui/non et valide la réponse 'y' ou 'n'.
     * @param label message affiché
     * @return {@code true} si 'y', {@code false} si 'n'
     */
    public boolean askYesNo(String label) {
        while (true) {
            System.out.print(label + " (y/n): ");
            String s = scanner.nextLine().trim().toLowerCase();
            if (s.equals("y")) return true;
            if (s.equals("n")) return false;
            System.out.println("Please type 'y' or 'n'.");
        }
    }

    /**
     * Lit un entier compris dans un intervalle [min, max].
     * @param label texte d'invite
     * @param min   valeur minimale incluse
     * @param max   valeur maximale incluse
     * @return entier valide
     */
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

    /**
     * Lit une saisie non vide.
     * @param label texte d'invite
     * @return chaîne non vide
     */
    public String askNonEmpty(String label) {
        while (true) {
            System.out.print(label);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Value cannot be empty.");
        }
    }


    /**
     * Affiche un message d'information.
     * @param message texte à afficher
     */
    public void info(String message) {
        System.out.println(message);
    }

    /** Affiche un message de fin. */
    public void goodbye() {
        System.out.println("Goodbye!");
    }
}
