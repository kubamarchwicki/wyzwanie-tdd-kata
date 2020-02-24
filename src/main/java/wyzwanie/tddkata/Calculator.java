package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Calculator {

    private String SEPARATOR = ",";

    public Integer add(String input) {
        if (input != null) {
            String[] inputToArray = input.split(SEPARATOR);
            int[] inputToIntArray = new int[inputToArray.length];
            for (int i = 0; i < inputToArray.length; i++) {
                try {
                    inputToIntArray[i] = Integer.parseInt(inputToArray[i].trim());
                }catch(NumberFormatException e){
                    System.out.println("Not a number");
                }
            }
            return IntStream.of(inputToIntArray).sum();

        }
        return 0;
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
