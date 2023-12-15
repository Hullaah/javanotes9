import java.util.InputMismatchException;
import java.util.Scanner;
public class QuadraticEquation {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it  has any roots. if A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C) throws IllegalArgumentException {
        if (A == 0)
            throw new IllegalArgumentException("A can't be 0");
        else {
            double discriminant = B*B - 4*A*C;
            if (discriminant < 0)
                throw  new IllegalArgumentException("Discriminant < 0.");
            return (-B + Math.sqrt(discriminant)) / (2*A);
        }
    }

    public static void main(String[] args) {
        boolean solveAnotherEquation = true;
        while (solveAnotherEquation) {
            System.out.print("Enter co-efficients of quadratic equation (A, B, C): ");
            Scanner in = new Scanner(System.in);
            try {
                int A = in.nextInt(), B = in.nextInt(), C = in.nextInt();
                System.out.println("Root: " + root(A, B, C));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a valid number.");
                continue;
            }
            while (true) {
                System.out.print("Solve another equation [Yes/No]? ");
                Scanner in2 = new Scanner(System.in);
                String option = in2.nextLine();
                if (option.equalsIgnoreCase("yes")) {
                    solveAnotherEquation = true;
                    break;
                }
                else if (option.equalsIgnoreCase("no")) {
                    solveAnotherEquation = false;
                    break;
                }
            }
        }
    }
}
