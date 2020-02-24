package wyzwanie.tddkata;

import java.util.Scanner;

import static java.lang.System.*;

public class Calculator {

    Integer add(String input) {
        if (!input.isEmpty()) {
            String[] array = input.split(",");
            int sum = 0;
            for (String s : array) {
                sum += Integer.valueOf(s);
            }
            return sum;
        }
        return 0;
    }

    //Do not modify code below this line. This is just a runner

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        out.println("Please enter calculation. Ctrl+d for exit.");

        Calculator calculator = new Calculator();
        out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            out.println(input + " ==> " + calculator.add(input));

            out.print("> ");
        }

    }
}
