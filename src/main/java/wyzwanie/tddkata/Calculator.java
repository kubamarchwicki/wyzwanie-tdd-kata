package wyzwanie.tddkata;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    public static final String DELIMITERS = "[$&+,:;=?@#|'<>.^*()%!-/{}\\[\\]]";


    public Integer add(String input) {

        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        return Stream.of(input.split(DELIMITERS))
                .filter(Calculator::isNumeric)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static boolean isNumeric(String number) {
        if (number == null) {
            return false;
        }
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


    //Do not modify code below this line. This is just a runner

    public static void main(String[] args) {
        String number = "23";
        String input2 = number.concat(Calculator.DELIMITERS.replaceAll("[\\[|\\]]", "")).concat(number);
        System.out.println(input2);

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