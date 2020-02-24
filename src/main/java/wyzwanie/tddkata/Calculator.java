package wyzwanie.tddkata;

import com.sun.xml.internal.xsom.impl.scd.Iterators;


import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String[] inputArray = input.split(",");
        int sum = 0;
           for (String num : inputArray) {
               sum += Integer.parseInt(num);
           }
           return sum;
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
