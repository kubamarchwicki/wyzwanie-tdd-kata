package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {

        /* return 0;  - line caused unreachable statement "if"
        */

        if (input.isEmpty()){
            return 0;
        }
        String[] inputArray = input.split(",");
        int sum = 0;
            for (String s : inputArray ){
                sum += Integer.parseInt(s);
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
