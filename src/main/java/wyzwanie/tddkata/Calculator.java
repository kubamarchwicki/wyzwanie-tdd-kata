package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    private static final String SEPARATORS = "[,]";

    public Integer add(String input) {
        return input.isEmpty() ? 0 :
                Stream.of(input.split(SEPARATORS))
                        .mapToInt(num -> Integer.parseInt(num.trim()))
                        .sum();
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
