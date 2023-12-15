import java.util.ArrayList;
import java.util.Scanner;

/**
 * reads a sequence of integers from the stdin and prints them
 * out in sorted order.
 */
public class ReadSequenceAndSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>(); // use an arrayList to store the numbers so that an arbitrary
                                                        // amount of integers can be read from stdin.
        System.out.print("Enter some numbers in random order: ");
        while (in.hasNextInt()) {
            int i, n = in.nextInt();
            if (n == 0) break;
            for (i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) > n)
                    break;
            }
            numbers.add(i, n);
        }
        for (var x: numbers)
            System.out.print(x + " ");
        System.out.println();
    }
}
