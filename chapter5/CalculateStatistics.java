import java.util.Scanner;

public class CalculateStatistics {
    public static void main(String[] args) {
        StatCalc calc = new StatCalc();
        Scanner in = new Scanner(System.in);
        double num;
        while ((num = in.nextDouble()) != 0) {
            calc.enter(num);
        }
        System.out.printf("Sum: %f\n", calc.getSum());
        System.out.printf("Count: %d\n", calc.getCount());
        System.out.printf("Mean: %f\n", calc.getMean());
        System.out.printf("Max: %f\n", calc.getMax());
        System.out.printf("Min: %f\n", calc.getMin());
        System.out.printf("Standard deviation: %f\n", calc.getStandardDeviation());
    }
}
