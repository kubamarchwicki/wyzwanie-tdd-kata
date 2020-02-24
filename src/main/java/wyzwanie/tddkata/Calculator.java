package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        if (input.isEmpty()) {
            return 0;
        }
            String[] p = input.split(",");
            int result = 0;
            int[] ans = new int[p.length];
            for (int i = 0; i < p.length; i++) {
                ans[i] = Integer.parseInt(p[i]);
                if (ans[i] < 0) {
                    throw new NumberFormatException("ujemna wartość");
                } else
                    result += ans[i];
            }
            return result;
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
