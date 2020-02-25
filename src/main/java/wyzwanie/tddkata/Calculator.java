package wyzwanie.tddkata;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    Integer add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        String delimiter = getDelimiter(input);
        String content = getContent(input, delimiter);

        return sum(content.split(delimiter));
    }

    private String getDelimiter(String input) {
        if (input.contains("\n")) {
            String[] lines = input.split("\n");

            validateDelimiterDeclaration(lines);

            return lines[0].substring(3, 4);
        } else {
            return ",";
        }
    }

    private void validateDelimiterDeclaration(String[] lines) {
        if (!lines[0].matches("//\\[.]")) {
            throw new IllegalArgumentException("Malformed delimiter declaration!");
        }
    }

    private String getContent(String input, String delimiter) {
        if (input.contains("\n")) {
            String[] lines = input.split("\n");

            validateContent(lines[1], delimiter);

            return lines[1];
        } else {
            validateContent(input, delimiter);

            return input;
        }
    }

    private void validateContent(String input, String delimiter) {
        if (!input.matches("^[-]?\\d+(" + delimiter + "[-]?\\d+)*$")) {
            throw new IllegalArgumentException("Malformed content!");
        }
    }

    private int sum(String[] input) {
        return Arrays.stream(input)
                .mapToInt(Integer::valueOf)
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
