package CampusN.DungeonCrawer;

/** Wizard character with default stats and spell. */
public class Wizard extends Character {
    public Wizard(String name) {
        super("Wizard", name, 8, 3, new OffensiveEquipment("Spell", "Fireball", 4));
    }
}
