package wyzwanie.tddkata;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {

        if (input==null || input.isEmpty()) {
            return 0;
        } else {
            String[] inputs = input.split("\\W+");
            int result=0;

           for (int i=0;i<inputs.length;i++){
               if (isNumeric(inputs[i])){
                   System.out.println(inputs[i]);
                   result+=Integer.parseInt(inputs[i]);
               }
            }
            return result;
        }
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
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
