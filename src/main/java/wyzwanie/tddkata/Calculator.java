package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    public Integer add(String input) throws Exception {


        if (isNullOrEmpty(input)) {
            return 0;
        }

        String delimeter = hasInputNewDelimeter(input);
        if (delimeter != ",") {
            input = input.substring(6);
        }

        if (!isNumber(input) && !input.contains(delimeter)) {
            throw new Exception("\"" + delimeter + "\" not found!");
        }

        return Stream.of(input.split(delimeter))
                .filter(Calculator::isNumber)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String input) {
        return null == input || input.isEmpty();
    }

    private static boolean isNumber(String input) {
        try {
            int inputInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static String hasInputNewDelimeter(String input) {
        if (input.startsWith("//[") && input.contains("]\n")) {
            return Character.toString(input.charAt(3));
        } else {
            return ",";
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
