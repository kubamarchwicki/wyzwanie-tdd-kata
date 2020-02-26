package wyzwanie.tddkata;


import com.sun.deploy.security.SelectableSecurityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Calculator {

    public Integer add(String input)  {
        int output=0;
        if(input ==null || input.isEmpty()){
           return 0;
       }


        char delimiter = setDelimiter(input);


            String[] valuesFromInput = input.split(String.valueOf(delimiter));
            for (String s : valuesFromInput) {
                try {
                    output += Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    System.out.println("wrong input");
                }
            }
            
        return output;
    }

     public Character setDelimiter(String input){
        String[] delimiters = new String[]{":",";","."," ","-","+","#","$","&","+",">","<","/"};
        List<String> properCommend = new ArrayList<>();
        for(String d : delimiters){
            properCommend.add("//["+d+"]");
        }

        for(String p : properCommend){
            if(input.contains(p)){
                return p.charAt(3);
            }
        }
             return ',';
     }
    public List<Character> disabledDelimiters(Character character){
        Character[] allDelimiters = new Character[]{':',';','.',' ','-','+','#','$','&','+','>','<','/'};
        List<Character> notAllowedCharacters = new ArrayList<>();
        for(Character c : allDelimiters){
            if(!c.equals(character)){
                notAllowedCharacters.add(c);
            }
        }
        return notAllowedCharacters;
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
