package CampusN.DungeonCrawer;

/** ici ce c'est les weapons */
public class OffensiveEquipment {
    private final String type; // "Weapon" or "Spell"
    private final String name;
    private final int attackLevel;

    public OffensiveEquipment(String type, String name, int attackLevel) {
        this.type = type;
        this.name = name;
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString() {
        return type + " '" + name + "' (attack=" + attackLevel + ")";
    }
}
