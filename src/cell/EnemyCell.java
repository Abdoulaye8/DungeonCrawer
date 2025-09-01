package cell;

import personnage.Character;
import CampusN.DungeonCrawer.Menu;

public class EnemyCell extends Cell {
    private final String enemyName;
    private int life;

    public EnemyCell(int pos, String enemyName, int life) {
        super(pos);
        this.enemyName = enemyName;
        this.life = life;
    }
    @Override
    public void interact(Character player, Menu menu) {
        menu.info("Un ennemi pparait : " + enemyName + " (life=" + life + ")");
        life -= player.getAttack();
        if (life > 0){
            menu.info(enemyName + " est encore en vie (life=" + life + " pv).");
        } else {
            menu.info(enemyName + " est vaincu !");
        }
    }
    @Override
    public String toString() {
        return "Ennemi : " + enemyName + " (" + getPosition() + ")";
    }
}
