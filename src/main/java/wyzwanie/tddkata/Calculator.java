package wyzwanie.tddkata;


import java.util.Scanner;


public class Calculator {

    public Integer add(String input) {
        String[] valuesFromInput = input.split(",");
        Integer output=0;

        for(String s : valuesFromInput){
            if(!s.equals(""))
            output+=Integer.valueOf(s);
        }
        return output;
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
