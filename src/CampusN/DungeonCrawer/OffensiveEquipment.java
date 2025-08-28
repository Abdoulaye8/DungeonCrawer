package CampusN.DungeonCrawer;

/** Classe abstraite pour équipements offensifs */
public abstract class OffensiveEquipment {
    private final String type;
    private final String name;
    private final int attackLevel;

    protected OffensiveEquipment(String type, String name, int attackLevel) {
        this.type = type;
        this.name = name;
        this.attackLevel = attackLevel;
    }

    public String getType() { return type; }
    public String getName() { return name; }
    public int getAttackLevel() { return attackLevel; }

    @Override
    public String toString() {
        return type + " '" + name + "' (attack=" + attackLevel + ")";
    }
}
