package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {


    public Integer add(String input) {
        String[] inputNumbers = input.split(",");

        if (isEmpty(input)){
            return 0;
        }
        else if (input.length() == 1){
            return stringToInt(input);
        }
        else {
            return sum(inputNumbers[0], inputNumbers[1]);
        }


    }

    private int sum(String numberOne, String numberTwo){
        return stringToInt(numberOne) + stringToInt(numberTwo);
    }

    private int stringToInt(String input){
        return Integer.parseInt(input);
    }

    private boolean isEmpty(String input){
        return input.isEmpty();
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
