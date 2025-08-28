package CampusN.DungeonCrawer;

/** Classe abstraite pour équipements défensifs */
public abstract class DefensiveEquipment {
    private final String type;
    private final String name;
    private final int defenseLevel;

    protected DefensiveEquipment(String type, String name, int defenseLevel) {
        this.type = type;
        this.name = name;
        this.defenseLevel = defenseLevel;
    }

    public String getType() { return type; }
    public String getName() { return name; }
    public int getDefenseLevel() { return defenseLevel; }

    @Override
    public String toString() {
        return type + " '" + name + "' (defense=" + defenseLevel + ")";
    }
}
