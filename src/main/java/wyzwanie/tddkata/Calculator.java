package wyzwanie.tddkata;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Calculator {
    public final static int UPPER_LIMIT = 1000;
    private String delimiter = ",";

    public Integer add(String input) {
        int result = 0;

        if(input == null || input.isEmpty())
            return result;

        if(hasCustomDelimiter(input))
            input = extractDelimiterAndPrepareInput(input);

        if(hasLetters(input))   // Setting letters to 0 allows to ignore them while doing calculations
            input = setLettersToZero(input);

        result = parseAndSumInput(input);
        return result;
    }

    private static boolean hasCustomDelimiter(String input){
        return input.matches("^/{2}\\[.]\\n.+$");
    }

    private static boolean hasLetters(String input){
        return input.matches("^.*[a-zA-Z]+.*$");
    }

    private String setLettersToZero(String input){
        /** Letters shall be ignored so changing letters to 0 allows
         *  input's elements to be added and result do not change.*/
        return input.replaceAll("[^\\d"+delimiter+"]", "0");
    }

    private String extractDelimiterAndPrepareInput(String input){
        delimiter = input.substring(3, input.indexOf("]"));
        if(delimiter.equals("."))
            delimiter = "\\.";
        input = input.substring(input.indexOf('\n')+1);
        return input;
    }

    private int parseAndSumInput(String input){
        List<String> inputList = Arrays.asList(input.split(delimiter));
        int result = 0;

        for ( String s: inputList ) {
            int value = Integer.parseInt(s);
            if (value < 0)
                throwNegativeNotAllowedWithMessage(inputList);
            result += value <= UPPER_LIMIT ? value : 0;
        }

        return result;
    }

    private void throwNegativeNotAllowedWithMessage(List<String> inputList){
        inputList = inputList.stream()
                .filter(s -> Integer.parseInt(s) < 0)
                .collect(Collectors.toList());

        String negativesToMessage = String.join(", ", inputList);
        throw new NegativeNotAllowed(negativesToMessage);
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
