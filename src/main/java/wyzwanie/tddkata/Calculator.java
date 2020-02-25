package wyzwanie.tddkata;

import java.util.Scanner;

import static java.lang.String.*;

public class Calculator {

    private static String FIRST_PART_SEPARATOR = "//[";
    private static String SECOND_PART_SEPARATOR = "]\n";


    Integer add(String input) {
        int sum = 0;
        String separator = ",";
        if (input == null || input.isEmpty()) {
            return 0;
        }
        if (input.contains(FIRST_PART_SEPARATOR) && input.contains(SECOND_PART_SEPARATOR)) {
            if (input.indexOf(FIRST_PART_SEPARATOR) == 0 && input.indexOf(SECOND_PART_SEPARATOR) == 4) {
                separator = valueOf(input.charAt(3));
                input = input.substring(6);

            } else {
                throw new IllegalArgumentException("Wrong order for separator");
            }
        }

        if (input.charAt(1) == separator.charAt(0) || isDigit(input)) {
            String[] array = input.split(separator);
            for (String s : array) {
                if (isDigit(s)) {
                    sum += Integer.valueOf(s);
                }
            }
        } else {
            throw new IllegalArgumentException("Wrong separator. Default separator is:','");
        }

        return sum;
    }

    private boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
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
