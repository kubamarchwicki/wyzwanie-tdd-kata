package wyzwanie.tddkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {

    static final String STR_COMMA = ",";

    public Integer add(String input) throws Exception {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = getDelimiter(input);
        List<String> lines = getLines(input);
        if (lines.size() > 1) {
            return addWithDelimiter(lines.get(1), delimiter);
        }
        return addWithDelimiter(input, delimiter);
    }

    private List<String> getLines(String input) {
        List<String> lines = new ArrayList<>();
        StringTokenizer newLineStringTokenizer = new StringTokenizer(input, "\n");
        while (newLineStringTokenizer.hasMoreTokens()) {
            lines.add(newLineStringTokenizer.nextToken());
        }
        return lines;
    }

    private String getDelimiter(String input) {
        if (isChangeDelimeterString(input)) {
            return input.substring(3,4);
        }
        return STR_COMMA;
    }

    private boolean isChangeDelimeterString(String input) {
        return input.startsWith("//[") && input.substring(2,3).equals("[") && input.substring(4,5).equals("]");
    }

    private Integer addWithDelimiter(String input, String delimiter) throws Exception {
        Integer value = getIntOrNull(input);
        if(value != null) {
            return value;
        }
        if (input.contains(delimiter)) {
            StringTokenizer inputStringTokenizer = new StringTokenizer(input, delimiter);
            Integer sum = 0;
            while (inputStringTokenizer.hasMoreTokens()) {
                value = getIntOrNull(inputStringTokenizer.nextToken());
                if (value != null) {
                    sum += value;
                }
            }
            return sum;
        } else {
            throw new Exception("No delimiter");
        }
    }

    private Integer getIntOrNull(String strValue) {
        try {
            return Integer.valueOf(strValue);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    //Do not modify code below this line. This is just a runner

    public static void main(String[] args) throws Exception {
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
