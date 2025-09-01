package cell;

import personnage.Character;
import campusnum.Menu;

public class EmptyCell extends Cell {
    public EmptyCell(int pos) {
        super(pos);
    }

    @Override
    public void interact(Character player, Menu menu) {
        // For empty cell, maybe no interaction happens
        menu.info("Tu es sur une case vide.");
    }

    @Override
    public String toString() {
        return "Case vide (" + getPosition() + ")";
    }
}
