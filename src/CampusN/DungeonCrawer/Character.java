package CampusN.DungeonCrawer;

/** Base character class (parent de Warrior/Wizard). */
public abstract class Character {
    private final String type; // "Warrior" or "Wizard"
    private String name;
    private int life;
    private int attack;
    private OffensiveEquipment offensiveEquipment; // default weapon/spell

    protected Character(String type, String name, int life, int attack, OffensiveEquipment eq) {
        this.type = type;
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.offensiveEquipment = eq;
    }

    public String getType() { return type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLife() { return life; }
    public void setLife(int life) { this.life = life; }
    public int getAttack() { return attack; }
    public void setAttack(int attack) { this.attack = attack; }
    public OffensiveEquipment getOffensiveEquipment() { return offensiveEquipment; }
    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) { this.offensiveEquipment = offensiveEquipment; }

    @Override public String toString() {
        return type + " {name='" + name + "', life=" + life + ", attack=" + attack +
                ", equipment=" + offensiveEquipment + "}";
    }
}
