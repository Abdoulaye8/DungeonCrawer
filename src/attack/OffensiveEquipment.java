package attack;

/**
 * Classe abstraite représentant un équipement offensif (par exemple une arme ou un sort).
 * <p>Contient les informations communes (type, nom, niveau d'attaque) et les accesseurs.</p>
 */
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
