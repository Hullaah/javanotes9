import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TestingSort {
    static void selectionSort(int[] A) {
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0;  // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j] > A[maxLoc]) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop

    }
    static void selectionSort(String[] A) {
        // Sort A into increasing order, using selection sort

        for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace
            // by swapping it with the number that is currently
            // in position lastPlace.

            int maxLoc = 0;  // Location of largest item seen so far.

            for (int j = 1; j <= lastPlace; j++) {
                if (A[j].compareTo(A[maxLoc]) >= 0) {
                    // Since A[j] is bigger than the maximum we've seen
                    // so far, j is the new location of the maximum value
                    // we've seen so far.
                    maxLoc = j;
                }
            }

            String temp = A[maxLoc];  // Swap largest item with A[lastPlace].
            A[maxLoc] = A[lastPlace];
            A[lastPlace] = temp;

        }  // end of for loop

    }
    public static void main(String[] args) {
        final int SIZE = 479826;
        int[] numbers = new int[SIZE];
        String[] words = new String[SIZE];
        long startTime, endTime;
        double timeTaken;

        Scanner in;
        File random_strings = new File("random_strings.txt");
        try {
            in = new Scanner(random_strings);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File does not exist");
        }

        for (int i = 0; i < SIZE; i++) {
            words[i] = in.nextLine();
            numbers[i] = (int)(Math.random() * SIZE) + 1;
        }
        System.out.println("Testing sorting numbers....");
        System.out.print("selectionSort() took ");
        startTime = System.nanoTime();
        selectionSort(numbers);
        endTime = System.nanoTime();
        timeTaken = (long) ((endTime - startTime) / 1e9);
        System.out.println(timeTaken + " seconds.");

        System.out.print("Arrays.sort() took ");
        startTime = System.nanoTime();
        Arrays.sort(numbers);
        endTime = System.nanoTime();
        timeTaken = (long) ((endTime - startTime) / 1e9);
        System.out.println(timeTaken + " seconds.");


        System.out.println("Testing sorting strings...");
        System.out.print("selectionSort() took ");
        startTime = System.nanoTime();
        selectionSort(words);
        endTime = System.nanoTime();
        timeTaken = (long) ((endTime - startTime) / 1e9);
        System.out.println(timeTaken + " seconds.");

        System.out.print("Arrays.sort() took ");
        startTime = System.nanoTime();
        Arrays.sort(words);
        endTime = System.nanoTime();
        timeTaken =  ((endTime - startTime) / 1e9);
        System.out.println(timeTaken + " seconds.");
    }
}