import java.util.ArrayList;

public class SeveralRandomIntegers {
    /**
     * Creates an ArrayList that contains several integers chosen at
     * random from a specified range of values.  All the integers
     * in the list are different.
     * @param count  the number of random integers to be created
     * @param max  the integers are chosen in the range 1 to max, inclusive
     * @return an ArrayList containing the integers.  The integers are
     *    random and are in a random order.
     * @throws IllegalArgumentException if max is greater than count.  In
     *    that case there are fewer than count different integers in the
     *    range 1 to max.
     */
    public static ArrayList<Integer> createRandomInts(int count, int max) {
        ArrayList<Integer> numbers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            numbers.add((int)(Math.random() * max) + 1);
        }
        return  numbers;
    }
    public static void main(String[] args) {
        System.out.println("10 integers chosen from the range 1 to 100:");
        for (int i = 0; i < 8; i++)
            System.out.println( createRandomInts(10,100) );
        System.out.println();
        System.out.println("10 integers chosen from the range 1 to 10:");
        for (int i = 0; i < 3; i++)
            System.out.println( createRandomInts(10,10) );
        System.out.println();
        System.out.println("25 integers chosen from the range 1 to 10000:");
        System.out.println( createRandomInts(25,10000) );
        System.out.println();
        System.out.println(createRandomInts(10,9));
    }
}
