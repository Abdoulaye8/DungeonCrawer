package CampusN.DungeonCrawer;
import java.util.Random;


    /** les 6 faces de dice. */
    public class Dice {
        private final Random random = new Random();
        public int roll() { return random.nextInt(6) + 1; }
    }

