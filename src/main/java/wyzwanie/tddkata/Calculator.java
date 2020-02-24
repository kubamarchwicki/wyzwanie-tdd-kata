package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        if (input.isEmpty()) return 0;

        String[] splittedInput = input.split(",");
        int[] numbers = new int[splittedInput.length];

        try {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(splittedInput[i]);
            }
        } catch (Exception e) {
            System.out.println("The provided input is incorrect, try using different input.");
        }

        if (numbers.length == 1) return numbers[0];

        if (numbers.length == 2) return numbers[0] + numbers[1];

        return 0;
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
