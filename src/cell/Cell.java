package cell;

import personnage.Character;
import CampusN.DungeonCrawer.Menu;

public abstract class Cell {
    private final int position;

    protected Cell(int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
    public abstract void interact(Character player, Menu menu);

    @Override
    public String toString() {
        return "Case " + position;
    }
}
