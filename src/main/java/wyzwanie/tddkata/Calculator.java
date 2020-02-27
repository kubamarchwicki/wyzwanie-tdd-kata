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

/*

// good example of implementation

public Integer add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        if (!Calculator.isNumeric(input) && !input.contains(",")) {
            throw new RuntimeException("Delimiter [,] not found");
        }

        return Stream.of(input.split(","))
                .filter(Calculator::isNumeric)
                .mapToInt(Integer::valueOf)
                .limit(2)
                .sum();
    }

    static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

 */

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
