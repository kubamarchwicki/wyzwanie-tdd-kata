package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        int result = 0;

        if(input.isEmpty())
            return result;
        else if(!input.contains(","))
            result += Integer.parseInt(input);
        else {
            String [] inputArr = input.split(",");
            for ( String s: inputArr )
                result += Integer.parseInt(s);
        }

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
