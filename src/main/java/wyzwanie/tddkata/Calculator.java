package wyzwanie.tddkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    public static final String DELIMITER_START = "//[";
    public static final String DELIMITER_END = "]";
    public static final String DEFAULT_DELIMITER = ",";

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Integer add(String input) throws Exception {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int sum = 0;

        String[] delimitedNumbersAsStrings;
        if (input.startsWith(DELIMITER_START)) {
            int lastDelimiterIndex = input.indexOf(DELIMITER_END, DELIMITER_START.length());
            String delimiter = input.substring(DELIMITER_START.length(), lastDelimiterIndex);
            assert input.substring(lastDelimiterIndex + 1, lastDelimiterIndex + 2).equals("\n");
            String delimitedNumbers = input.substring(lastDelimiterIndex + 2);
            if (!delimitedNumbers.contains(delimiter)) {
                throw new Exception("Cannot find custom delimiter: " + delimiter + " in: " + delimitedNumbers);
            }
            delimitedNumbersAsStrings = delimitedNumbers.split(delimiter);
        } else {
            if (!input.contains(DEFAULT_DELIMITER) && !isNumeric(input)) {
                throw new Exception("No default delimiter found in input: " + input);
            }
            delimitedNumbersAsStrings = input.split(DEFAULT_DELIMITER);
        }

        List<String> allNegativeNumbers = new ArrayList<>();

        for (String singleNumber : delimitedNumbersAsStrings) {
            try {
                int number = Integer.parseInt(singleNumber);
                if (number < 0) {
                    allNegativeNumbers.add(singleNumber);
                } else if (number > 1000) {
                    continue;
                }
                sum += number;
            } catch (NumberFormatException exc) {
                // ninja is hidden here...
            }
        }

        if (!allNegativeNumbers.isEmpty()) {
            throw new NegativeNotAllowed(String.join(",", allNegativeNumbers));
        }

        return sum;
    }


    public static class NegativeNotAllowed extends Exception {
        public NegativeNotAllowed(String s) {
            super(s);
        }
    }

    //Do not modify code below this line. This is just a runner

    public static void main(String[] args) throws Exception {
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
