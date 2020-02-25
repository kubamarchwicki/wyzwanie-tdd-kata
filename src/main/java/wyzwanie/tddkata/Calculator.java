package wyzwanie.tddkata;

import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {

    public Integer add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }
        String[] splittedInput = input.split("\n");
        String delimeter = ",";

        if (isNewDelimeterDefined(splittedInput)){
         if (isDelimeterDeclaredCorrectly(splittedInput[0])){
             delimeter = extractDelimeter(splittedInput[0]);
             input = splittedInput[1];
         }else {
             input = splittedInput[1];
         }
        }

        if (!Calculator.isNumeric(input) && !input.contains(delimeter)) {
            throw new RuntimeException("Delimiter ["+delimeter+"] not found");
        }

        return Stream.of(input.split(delimeter))
                .filter(Calculator::isNumeric)
                .mapToInt(Integer::valueOf)
                //.limit(2)
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

    private boolean isNewDelimeterDefined(String[] splittedInput){
        return splittedInput.length == 2;

    }
    private boolean isDelimeterDeclaredCorrectly(String delimeterDeclaration){
        return delimeterDeclaration.matches("//\\[.+\\]");
    }
    private String extractDelimeter(String line){
       return line.replaceAll("[/\\[\\]]","");
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
