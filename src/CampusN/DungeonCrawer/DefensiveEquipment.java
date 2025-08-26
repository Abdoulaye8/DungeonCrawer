package CampusN.DungeonCrawer;

// position
public class DefensiveEquipment {
    private final String type; // "Shield" or "Potion"
    private final String name;
    private final int defenseLevel;

    public DefensiveEquipment(String type, String name, int defenseLevel) {
        this.type = type;
        this.name = name;
        this.defenseLevel = defenseLevel;
    }

    @Override
    public String toString() {
        return type + " '" + name + "' (defense=" + defenseLevel + ")";
    }
}
