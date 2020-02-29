package wyzwanie.tddkata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {
    public final static int UPPER_LIMIT = 1000;
    private String delimiter = ",";

    public Integer add(String input) {
        int result = 0;


        if(input == null || input.isEmpty())
            return result;
        else if(input.matches("^/{2}\\[.]\\n.+$")){
            delimiter = Character.toString(input.charAt(3));
            input = input.substring(input.indexOf('\n')+1);
        }

        if(input.matches("^.*[a-zA-Z]+.*$")){
            // TODO: Refactor
            input = input.replaceAll("[^\\d"+delimiter+"]", "0");
        }


        if(!input.contains(delimiter)) {
            int inputParsed = Integer.parseInt(input);
            if (inputParsed < 0) {
                throw new NegativeNotAllowed(input);
            }
            result += inputParsed <= UPPER_LIMIT ? inputParsed : 0;
        }
        else {
            result = inputParser(input);
        }

        return result;
    }

    private int inputParser(String input){
        boolean hasNegatives = false;
        List<String> inputList = Arrays.asList(input.split(delimiter));
        int result = 0;
        String negativesToMessage = "";

        for ( String s: inputList ) {
            int value = Integer.parseInt(s);
            if (value < 0) {
                hasNegatives = true;
                negativesToMessage += value + ", ";
            }
            if (!hasNegatives)
                result += value <= UPPER_LIMIT ? value : 0;
        }

        if(hasNegatives)
            throw new NegativeNotAllowed(negativesToMessage.replaceAll(", $", ""));

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
