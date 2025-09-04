package db;

public class Character {
    private int id;
    private String type;
    private String name;
    private int lifePoints;
    private int strength;
    private String offensiveEquipment;
    private String defensiveEquipment;

    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLifePoints() { return lifePoints; }
    public void setLifePoints(int lifePoints) { this.lifePoints = lifePoints; }

    public int getStrength() { return strength; }
    public void setStrength(int strength) { this.strength = strength; }

    public String getOffensiveEquipment() { return offensiveEquipment; }
    public void setOffensiveEquipment(String offensiveEquipment) { this.offensiveEquipment = offensiveEquipment; }

    public String getDefensiveEquipment() { return defensiveEquipment; }
    public void setDefensiveEquipment(String defensiveEquipment) { this.defensiveEquipment = defensiveEquipment; }
}
