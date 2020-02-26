package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public static Integer add_zadanie1(String input) {
        if (input == null || input.equals("")) {
            return 0;
        }

        if (!isNumeric(String.valueOf(input.charAt(input.length() - 1)))) {
            input = input.substring(0, input.length() - 1);
        }

        String[] inputAsStringArray = input.split(",");


        if (inputAsStringArray.length == 1) {
            return Integer.parseInt(input);
        }

        int sum = 0;
        int howManyNumbersSum = inputAsStringArray.length;

        if (inputAsStringArray.length >= 2) {
            howManyNumbersSum = 2;
        }

        for (int i = 0; i < howManyNumbersSum; i++) {
            if (isNumeric(inputAsStringArray[i])) {
                sum += Integer.parseInt(inputAsStringArray[i]);
            }
        }
        return sum;
    }

    //zadanie-2
    public static Integer add(String input) {

        if (input == null) return 0;
        if (!input.matches(".*\\d.*")) return 0;

        int sum = 0;
        String numbers = input.replaceAll("[^\\d.]", ",");
        String[] nums = numbers.split(",");

        for (String num : nums) {
            if (!num.equals("")) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }

    private static boolean isNumeric(String input) {
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
