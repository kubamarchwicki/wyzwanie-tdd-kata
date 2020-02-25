package wyzwanie.tddkata;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.lang.IllegalArgumentException;

public class Calculator {

    public Integer add(String input) throws IllegalArgumentException {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String delimiter = CalculatorHelper.findDelimiter(input);
        if (input.startsWith("//[") && input.contains("]\n")) {
            String[] temp = input.split("]\n", 2);
            input = temp[1];
        }
        String[] arrayOfGivenNumbers = input.split(delimiter);
        if (arrayOfGivenNumbers.length == 1) {
            try {
                return Integer.parseInt(arrayOfGivenNumbers[0]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid input data");
            }
        } 
        Stream<String> stream = Arrays.stream(arrayOfGivenNumbers); 
        Integer result = stream
            .map(s -> {
                try {
                    return Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return 0;
                }
            })
            .reduce(0, (sum, number) ->  sum + number);
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
