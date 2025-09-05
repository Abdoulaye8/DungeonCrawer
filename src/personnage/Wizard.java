package personnage;

import attack.Sort;

/** Implémentation concrète d'un équipement offensif de type "Arme". */
public class Wizard extends Character {
    public Wizard(String name) {
        super("Wizard", name, 8, 3, new Sort("Boule de Feu", 4));
    }
}
