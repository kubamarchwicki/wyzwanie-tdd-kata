package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

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
