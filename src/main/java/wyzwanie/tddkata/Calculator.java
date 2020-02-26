package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    public Integer add(String input) throws Exception {
        if (isNullOrEmpty(input)) {
            return 0;
        } else if (!isNumber(input) && !input.contains(",")) {
            throw new Exception("\",\" not found!");
        }

        return Stream.of(input.split(","))
                .filter(Calculator::isNumber)
                .mapToInt(Integer::parseInt)
                .limit(2)
                .sum();
    }

    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static boolean isNumber(String input) {
        try {
            int inputInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
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
