package wyzwanie.tddkata;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        if (Objects.isNull(input) || input.isEmpty()){
            return 0;
        }

        if (!isDigit(input) && !containsComa(input)){
            throw new IllegalArgumentException();
        }

        return Arrays.stream(input.split(","))
                .mapToInt(this::mapIgnoringNonNumbers)
                .limit(2)
                .sum();
    }

    private boolean isDigit(String input) {
        return input.matches("\\d+");
    }

    private boolean containsComa(String input) {
        return input.contains(",");
    }

    private int mapIgnoringNonNumbers(String element) {
        if (isDigit(element)){
            return Integer.parseInt(element);
        } else {
            return 0;
        }
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
