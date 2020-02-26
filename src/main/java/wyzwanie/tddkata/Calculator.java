package wyzwanie.tddkata;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

    public Integer add(String input) {
        int result = 0;
        String delimiter = ",";

        if(input == null || input.isEmpty())
            return result;
        else if(input.matches("^/{2}\\[.]\\n.+$")){
            delimiter = Character.toString(input.charAt(3));
            input = input.substring(input.indexOf('\n')+1);
        }

        if(input.matches("^.*[a-zA-Z]+.*$")){
            input = input.replaceAll("[^\\d"+delimiter+"]", "0");
        }

        if(!input.contains(delimiter))
            result += Integer.parseInt(input);
        else {
            String [] inputArr = input.split(delimiter);
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
