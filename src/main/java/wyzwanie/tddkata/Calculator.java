package wyzwanie.tddkata;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    private final static String DEFAULT_DELIMITER = ",";

    public Integer add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        if (!Calculator.isNumeric(input) &&
                (!input.contains(",") && !input.startsWith("//"))) {
            throw new RuntimeException("Delimiter [,] not found");
        }

        String defaultInput = input;
        String delimiter = DEFAULT_DELIMITER;
        if (input.startsWith("//")) {
            delimiter = String.valueOf(input.charAt(3));
            defaultInput = input.split("\\n")[1];
        }

        return Stream.of(defaultInput.split(delimiter))
                .filter(Calculator::isNumeric)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    static boolean isNumeric(String strNum) {
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
