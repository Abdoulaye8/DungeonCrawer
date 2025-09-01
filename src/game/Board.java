package game;

import java.util.List;
import java.util.ArrayList;

import attack.Arme;
import cell.WeaponCell;
import cell.Cell;
import cell.EmptyCell;
import cell.EnemyCell;
import cell.PotionCell;

public class Board {
    private final List<Cell> cells;

    public Board() {
        cells = new ArrayList<>();
        // Plateau simplifié (4 cases fixes)
        cells.add(new EmptyCell(1));
        cells.add(new EnemyCell(2, "Gobelin", 5));
        cells.add(new WeaponCell(3, new Arme("Hache", 4)));
        cells.add(new PotionCell(4, 3));
    }

    public int getSize() {
        return cells.size();
    }

    public Cell getCell(int pos) {
        return cells.get(pos - 1);
    }
}
