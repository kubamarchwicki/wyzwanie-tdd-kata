package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {
        public boolean isInt(String s) throws NumberFormatException{
            try{
                Integer.parseInt(s);
                return true;
            } catch (NumberFormatException ex){
                return false;
            }
        }
        
        public Integer add(String input) {
            if(input == null){
                return 0;
            }
            String delimitter = "";
            if(input.startsWith("//")){
                for(int i=input.indexOf("[")+1;i<input.indexOf("]");i++){
                    delimitter += input.charAt(i);
                }
            }
            else{
                delimitter = ",";
            }
            
            String[] inputNumber = input.split(delimitter);
            int number = 0;
            for(int j=0; j<inputNumber.length;j++){
                if(isInt(inputNumber[j])){
                    number += Integer.parseInt(inputNumber[j]);
                }
            }
            return number;
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
