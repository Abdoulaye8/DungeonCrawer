package cell;

public class PotionCell extends Cell {
    private final int healAmount;

    public PotionCell(int pos, int healAmount) {
        super(pos);
        this.healAmount = healAmount;
    }

    @Override
    public void interact(Character player, Menu menu) {
        int newLife = player.getLife() + healAmount;
        player.setLife(newLife);
        menu.info("Tu bois une potion et récupères " + healAmount + " pv (total=" + newLife + ").");
    }

    @Override
    public String toString() {
        return "Potion (+ " + healAmount + " life)";
    }
}