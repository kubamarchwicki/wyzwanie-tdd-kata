package wyzwanie.tddkata;

import java.util.Scanner;

public class Calculator {

  public Integer add(String input) {

    InputChecker inputChecker = new InputChecker();

    if (input == null || input.isEmpty()) {
      return 0;
    }

    if (inputChecker.hasNumbersOnly(input)) {
      String[] inputArray = inputChecker.replaceSeparatorsWithComma(input);
      int result = 0;

      for (String number : inputArray) {
        result += Integer.parseInt(number);
      }

      return result;
    }

    return 0;
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
