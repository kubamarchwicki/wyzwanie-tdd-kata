package wyzwanie.tddkata;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Calculator {
    private int result;

    public Integer add(String input) {
        if (input == null || input.isEmpty()) {
            result = 0;
        } else if (!isNumeric(input)) {
            input = input.replaceAll("[^0-9,]+","");
            addNumbers(input);
        } else if (isNumeric(input)) {
            addNumbers(input);
        }
        return result;
    }

    public int addNumbers(String input) {
        result = 0;
        String[] inptArray = input.split(",");
        int[] nums = StringArrayToIntArray(inptArray);
        for (int i = 0; i < nums.length; i++) {
            if (nums.length >= 2) {
                return result = nums[0] + nums[1];
            } else if ((nums.length == 1) || (nums.length == 1 && input.substring(input.length() - 1).equals(","))) {
                return result = nums[0];
            }
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    int[] StringArrayToIntArray(String[] stringArray) {
        return Stream.of(stringArray).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter 2 numbers separated by a comma...");

        Calculator calculator = new Calculator();
        System.out.print("> ");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(input + " ==> " + calculator.add(input));

            System.out.print("> ");
        }

    }
}
