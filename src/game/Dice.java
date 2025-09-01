package game;
import java.util.Random;

public class Dice {
    private final Random random = new Random();

    // Dé truqué pour tester le plateau (toujours 1)
    public int roll() { return 1; }
}
