package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        String s = input.trim()
                .replace(",", "")
                .replace(" ", "");
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            result += Integer.parseInt(s.substring(j, j + 1));
        }
        return result;
    }

    //Do not modify code below this line. This is just a runner.

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
