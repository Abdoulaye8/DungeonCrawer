package cell;

import campusnum.Menu;
import attack.OffensiveEquipment;
import personnage.Character;

public class WeaponCell extends Cell {
    private final OffensiveEquipment weapon;

    public WeaponCell(int pos, OffensiveEquipment weapon) {
        super(pos);
        this.weapon = weapon;
    }

    @Override
    public void interact(Character player, Menu menu){
        menu.info("Tu trouves une arme : " + weapon);
        player.setOffensiveEquipment(weapon);
        menu.info(player.getName() + " s'équipe de " + weapon.getName() + ".");
    }

    @Override
    public String toString() {
        return "Arme (" + weapon + ")";
    }
}
