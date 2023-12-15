import java.util.Scanner;

public class RomanNumeral {

    private final static String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private  final  static int[] ARABIC_NUMERALS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final int integerRepresentation;
    private final String stringRepresentation;

    public RomanNumeral(int n) {
        if (n < 1 || n > 4000) // n is beyond or below the roman numerals that can be represented in this program
            throw new NumberFormatException("n must be greater than 0 and less than 4000");

        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (n - ARABIC_NUMERALS[index] < 0)
            index++;
        while (true) {
            n -= ARABIC_NUMERALS[index];
            builder.append(ROMAN_NUMERALS[index]);
            if (n == 0)
                break;
            while (n - ARABIC_NUMERALS[index] < 0) {
                index++;
            }
        }

        integerRepresentation = n;
        stringRepresentation = builder.toString();
    }

    public RomanNumeral(String word) {
        if (!isLegalRomanNumeral(word))
            throw new NumberFormatException("Illegal Roman numeral, " + word);

        int total = 0, index = 0, wordIndex = 0, count = 0;
        String wordCopy = word;
        while (!wordCopy.isEmpty()) {
            if (index >= ROMAN_NUMERALS.length)
                throw new NumberFormatException("Illegal Roman numeral, " + word);
            if (wordCopy.startsWith(ROMAN_NUMERALS[index])) {
                wordIndex = ROMAN_NUMERALS[index].length();
                total += ARABIC_NUMERALS[index];
                wordCopy = wordCopy.substring(wordIndex);
                if (index == 0 || index == 4 || index == 8 || index == 12) {
                    count++;
                    if (count > 3)
                        throw new NumberFormatException("Illegal Roman numeral, " + word);
                    continue;
                }
            }
            count = 0;
            index++;
        }

        integerRepresentation = total;
        stringRepresentation = word;
    }

    public String toString() {
        return  stringRepresentation;
    }

    public int toInt() {
        return integerRepresentation;
    }

    private static boolean isLegalRomanNumeral(String word) {
        char[] legalRomanNumerals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        boolean legal = false;
        if (word.isEmpty())
            return false;
        for (char letter: word.toCharArray()) {
            legal = false;
            for (char legalRomanNumeral: legalRomanNumerals) {
                if (letter == legalRomanNumeral) {
                    legal = true;
                    break;
                }
            }
            if (!legal)
                break;
        }
        return legal;
    }

    public static void main(String[] args) {
        while (true) {
            System.out.print("Enter a number (Arabic/Roman): ");
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            if (input.isEmpty())
                break;
            try {
                if (Character.isDigit(input.charAt(0))) {
                    int number = Integer.parseInt(input);
                    System.out.println("Roman numeral of " + number + " is " + new RomanNumeral(number));
                } else {
                    System.out.println("Arabic numeral of " + input + " is " + new RomanNumeral(input.toUpperCase()).toInt());
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
