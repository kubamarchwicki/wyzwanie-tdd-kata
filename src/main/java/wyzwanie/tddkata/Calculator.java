package wyzwanie.tddkata;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.lang.IllegalArgumentException;

public class Calculator {

    public Integer add(String input) throws IllegalArgumentException, NegativeNotAllowed {
        if (input == null || input.length() == 0) {
            return 0;
        }
        String delimiter = CalculatorHelper.findDelimiter(input);
        if (input.startsWith("//[") && input.contains("]\n")) {
            String[] temp = input.split("]\n", 2);
            input = temp[1];
        }
        String[] arrayOfGivenNumbers = input.split(delimiter);
        List<String> listOfGivenNumbers = Arrays.asList(arrayOfGivenNumbers);
        List<Integer> listOfIntegers = listOfGivenNumbers.stream()
            .filter(Calculator::isNumber)
            .map(s -> Integer.parseInt(s))
            .collect(Collectors.toList());
        if (listOfIntegers.size() == 0) {
            throw new IllegalArgumentException("invalid input data");
        }
        containsNegatives(listOfIntegers);    
        Integer result = listOfIntegers.stream()    
            .filter(num -> num < 2000)
            .reduce(0, (sum, number) ->  sum + number);
        return result;
    }

    static void containsNegatives(List<Integer> input) throws NegativeNotAllowed {
        String message = input.stream() 
            .filter(n -> n < 0)
            .map(n -> n.toString())
            .collect(Collectors.joining(", "));
       if (!message.equals("")) {
           throw new NegativeNotAllowed(message);
       }

    }

    static boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
