package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {
//zadanie-2
    public static Integer add(String input) {
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
