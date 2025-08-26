package CampusN.DungeonCrawer;

/** Warrior character with default stats and weapon. */
public class Warrior extends Character {
    public Warrior(String name) {
        super("Warrior", name, 12, 5, new OffensiveEquipment("Weapon", "Club", 3));
    }
}
