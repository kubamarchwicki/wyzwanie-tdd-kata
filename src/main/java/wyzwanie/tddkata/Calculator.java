package wyzwanie.tddkata;


import com.sun.deploy.security.SelectableSecurityManager;

import java.util.*;
import java.util.regex.Pattern;


public class Calculator {

    static final Deque<Character> queue = new ArrayDeque<>();

    public Integer add(String input)  {
        int output=0;
        if(input ==null || input.isEmpty()){
           return 0;
       }

        char delimiter = setDelimiter(input);

        if(queue.peek()==null){
            queue.add(',');
        }
        if(delimiter!=queue.peekLast()&& delimiter!='X'){
            queue.add(delimiter);
            System.out.println("Delimiter has been changed into '"+queue.peekLast()+"'. High five!");
            return 5;
        }
        List<Character> notAllowedDelimiters = disabledDelimiters(queue.peekLast());
        for(Character c : notAllowedDelimiters) {
            if (input.contains(c.toString())){
                return -1;
            }
        }

            String[] valuesFromInput = input.split(String.valueOf(queue.peekLast()));
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
        String[] delimiters = new String[]{":",";","."," ","-","#","$","&",">","<",",","/"};
        List<String> properCommend = new ArrayList<>();
        for(String d : delimiters){
            properCommend.add("//["+d+"]");
        }

        for(String p : properCommend){
            if(p.contains(input)){
                return p.charAt(3);
            }
        }
        return 'X';
     }
    public List<Character> disabledDelimiters(Character character){
        Character[] allDelimiters = new Character[]{':',';','.',' ','-','#','$','&','>','<',',','/'};
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
