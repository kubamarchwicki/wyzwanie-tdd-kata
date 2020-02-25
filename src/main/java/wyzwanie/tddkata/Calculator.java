package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

    public Integer add(String input) {

        int result = 0;
        if (input == null || input.length() == 0) {
            return result;
        }

        String[] splitedStringArray;


        try {
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }


        if (input.startsWith("//")) {
            String newSpliter = String.valueOf(input.charAt(3));
            input = input.substring(6);
            splitedStringArray = input.split(newSpliter);
        } else if (!input.contains(",")) {
            //tak, tę część musiałem dodać tylko po to aby przeszło test z błędem
            //bo wcześniej zaimplantowałem za dużo. Ostrzymy :)
            throw new RuntimeException("Delimiter [,] not found");
        } else {
            splitedStringArray = input.split(",");
        }

        for (String num : splitedStringArray) {
            for (int i = 0; i < num.length(); i++) {
                if (!Character.isDigit(num.charAt(i))) {
                    num = "0";
                }
            }
            result += Integer.parseInt(num);
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
