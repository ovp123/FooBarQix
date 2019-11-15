package stringcalculator;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {

    static String DELIMITER_START = "//[";
    static String DELIMITER_END = "]\n";

    static int MAX_VALUE_TO_ADD = 1000;

    public static int add(String numbers) throws IllegalArgumentException {

        isContainingNoNegativeNumbers(numbers);
        if (isEmptyNumbers(numbers)) return 0;

        IntStream separatedNumbers = getSeparatedNumbers(numbersWithNormalizedDelimiters(numbers));
        IntStream separatedNumbersWithoutBigNumbers = ignoreNumbersGreaterThanMax(separatedNumbers);

        return separatedNumbersWithoutBigNumbers.sum();
     }

    private static IntStream ignoreNumbersGreaterThanMax(IntStream separatedNumbers) {
        return separatedNumbers.filter(n->n<MAX_VALUE_TO_ADD);
    }

    private static String numbersWithNormalizedDelimiters(String numbers){

        if (isThereADelimiterInNumbers(numbers)) {
            String[] providedDelimiter = getDelimiterRegEx(numbers);
            String numbersWithoutProvidedDelimiter = numbers.substring(numbers.indexOf(DELIMITER_END)+ DELIMITER_END.length());
            return replaceEachDelimiterWithNormalizedDelimiter(providedDelimiter, numbersWithoutProvidedDelimiter);
        }else{
            return  numbers;
        }
    }

    private static String replaceEachDelimiterWithNormalizedDelimiter(String[] providedDelimiter, String numbersWithoutProvidedDelimiter) {
        String result = numbersWithoutProvidedDelimiter;
        for (String delimiter : providedDelimiter) {
            result = result.replace(delimiter,",");
        }
        return result;
    }

    private static String[] getDelimiterRegEx(String numbers) {

        return numbers.substring(DELIMITER_START.length(),numbers.indexOf(DELIMITER_END)).split("]\\[");

    }

    private static boolean isThereADelimiterInNumbers(String numbers) {

        return numbers.startsWith(DELIMITER_START) && numbers.contains(DELIMITER_END);
    }

    private static IntStream getSeparatedNumbers(String numbers) {

        return Arrays.stream(numbers.split("[\\n,]"))
                .mapToInt(x -> Integer.valueOf(x));
    }

    private static boolean isEmptyNumbers(String numbers) {
        if (numbers == "") return true;
        return false;
    }

    private static void isContainingNoNegativeNumbers(String numbers) {
        if (numbers.contains("-")) throw new IllegalArgumentException("input must be positive");
    }
}
