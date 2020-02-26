package wyzwanie.tddkata;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Calculator {


    Integer add(String input) {

        if (isNullOrIsEmpty(input)) {
            return 0;
        } else if (isPattern(input)) {
            return calculateWithPattern(input);
        }

        return calculateWithOutPattern(input);

    }

    private int calculateWithOutPattern(String input){

        if (!Calculator.isNumeric(input) && !input.contains(",")) {
            throw new RuntimeException("Delimiter [,] not found");
        } else if (input.length() == 1) {
            return stringToInt(input);
        } else {
            return Stream.of(input.split(","))
                    .filter(Calculator::isNumeric)
                    .mapToInt(Integer::parseInt)
//                    .limit(2)
                    .sum();
        }
    }

    private int calculateWithPattern(String input){

        char delimeter = input.charAt(3);
        String delmiterString = Character.toString(delimeter);
        String substring = input.substring(7);
        Pattern patternSubstring = Pattern.compile("^(-?.*"+delimeter+"){1,}-?.*$");

        if (patternSubstring.matcher(substring).matches())
        {
            return Stream.of(substring.split(delmiterString))
                    .filter(Calculator::isNumeric)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
         throw new RuntimeException("Delimiter doesn't match");
    }

    private boolean isPattern(String input){
        Pattern pattern = Pattern.compile("^//.*\\\\n.*$");
        return pattern.matcher(input).matches();
    }

    private static boolean isNumeric(String strNum) {
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

    private int sum(String numberOne, String numberTwo){
        return stringToInt(numberOne) + stringToInt(numberTwo);
    }

    private int stringToInt(String input){
        return Integer.parseInt(input);
    }

    private boolean isEmpty(String input){
        return input.isEmpty();
    }

    private boolean isNullOrIsEmpty(String input){
        return Objects.isNull(input) || isEmpty(input);
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
