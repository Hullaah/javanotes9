public class DiceSimulation {
    public static void main(String[] args) {
        final int NUMBER_OF_EXPERIMENTS = 10000;
        PairOfDice dice = new PairOfDice();

        System.out.println("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls");
        System.out.println("----------   --------------   ----------------   --------------");
        for (int i = 2; i < 13; i++) {
            StatCalc stats = new StatCalc();
            for (int j = 0; j < NUMBER_OF_EXPERIMENTS; j++) {
                stats.enter(rollDice(dice, i));
            }
            System.out.printf("%6d", i);
            System.out.printf("%18.3f", stats.getMean());
            System.out.printf("%19.3f", stats.getStandardDeviation());
            System.out.printf("%14.3f", stats.getMax());
            System.out.println();
        }
    }
    public static int rollDice(PairOfDice dice, final int N) {
        int rollCt = 0;  // Number of rolls made.
        do {
            dice.roll();
            rollCt++;
        } while ( dice.getTotal() != N );
        return rollCt;
    }
}
