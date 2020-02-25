package wyzwanie.tddkata;

import wyzwanie.tddkata.delimiter.GetDelimiter;
import wyzwanie.tddkata.delimiter.GetDelimiterDefaultImpl;

import java.util.Scanner;

public class Calculator {

    private final GetDelimiter getDelimiter = new GetDelimiterDefaultImpl();

    public Integer add(String input) {
        int result = 0;
        if (input == null || input.length() == 0)
            return result;

        String delimiter = getDelimiter.getDelimiterFromInput(input);
        String numbers = getNumbers(input);

        for (String element : numbers.split(delimiter)) {
            result += getNumber(element);
        }
        return result;
    }

    private int getNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException ignore) {
            return 0;
        }
    }

    private String getNumbers(String input) {
        if (input.contains("\n")) {
            return input.split("\n")[1];
        }
        return input;
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
