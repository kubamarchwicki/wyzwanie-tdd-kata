package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Calculator {

    private static final String DEFAULT_SEPARATOR = ",";


    public Integer add(String input) {
        int sum =0;
        if (input != null) {
            String[] inputExtractDelimiter = input.split("\\\\n");
            String separator = DEFAULT_SEPARATOR;
            String computedInput = input;
            if(inputExtractDelimiter.length == 2) {
                int firstDelimiterOccurrence = inputExtractDelimiter[0].indexOf("[");
                int secondDelimiterOccurrence = inputExtractDelimiter[0].indexOf("]");
                separator = inputExtractDelimiter[0].substring(firstDelimiterOccurrence + 1, secondDelimiterOccurrence);
                computedInput = inputExtractDelimiter[1];
                if (separator.isEmpty()) {
                    separator = DEFAULT_SEPARATOR;
                }
            }
            sum = countSum(computedInput,separator);
        }
        return sum;
    }

    private Integer countSum(String inputNumbers, String separator){
        String[] inputToArray = inputNumbers.split(separator);
        int[] inputToIntArray = new int[inputToArray.length];
        for (int i = 0; i < inputToArray.length; i++) {
            try {
                inputToIntArray[i] = Integer.parseInt(inputToArray[i].trim());
            } catch (NumberFormatException e) {
                System.out.println("Not a number");
            }
        }
        return IntStream.of(inputToIntArray).sum();
    }

    //Do not modify code below this line. This is just a runner

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter calculation. Ctrl+d for exit.");

        Calculator calculator = new Calculator();
        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(input + " ==> " + calculator.add(input));

            System.out.print("> ");
        }

    }
}
