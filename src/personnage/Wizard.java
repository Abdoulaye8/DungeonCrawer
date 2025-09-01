package personnage;

import attack.Sort;

/** Wizard character with default stats and spell. */
public class Wizard extends Character {
    public Wizard(String name) {
        super("Wizard", name, 8, 3, new Sort("Boule de Feu", 4));
    }
}
