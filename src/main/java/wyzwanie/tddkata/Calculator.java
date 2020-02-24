package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {

        final String COMMA_SIGN = ",";
        String [] splitNumbers = input.split(COMMA_SIGN);

        Integer sum = 0;
        for (int i = 0; i < splitNumbers.length; i++) {
            sum += Integer.valueOf(splitNumbers[i]);
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
