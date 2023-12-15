import java.math.BigInteger;
import java.util.Scanner;

public class UsingBigInteger {
    
    public static void main(String[] args) {
        BigInteger number = readInput();
        System.out.print("The 3N + 1 sequence of " + number + " has " + calculateSequence(number) + " numbers in the sequence.");
    }

    public static BigInteger readInput() {
        while (true) {
            System.out.print("Enter a number: ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            try {
                return new BigInteger(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, \"" + input + "\". Enter a valid number ");
            }
        }
    }

    public  static int calculateSequence(BigInteger N) {
        int count = 0;
        while ( !N.equals(new BigInteger("1")) ) {
            if ( !N.testBit(0))  // If N is even...
                N = N .divide(new BigInteger("2"));
            else
                N = new BigInteger("3").multiply(N).add(new BigInteger("1"));
            System.out.println(N);
            count++;
        }
        return  count;
    }
}
