package wyzwanie.tddkata;

import java.lang.IllegalArgumentException;

class CalculatorHelper {

    static String[] splitGivenInput(String input) {
        String[] output = new String[0];
        return output;
    }

    
    static String findDelimiter(String input) throws IllegalArgumentException  {
        if (input.startsWith("//[") && input.contains("]\n")) {
            int indexOfClosingTag = input.indexOf("]\n");
            String delimiter = input.substring(3, indexOfClosingTag);
            if (delimiter.length() == 0) {
                return ",";
            }
            try {
                Integer.parseInt(delimiter);
                throw new IllegalArgumentException("Delimiter not defined");
            } catch(NumberFormatException e) {
                return delimiter;
            }
        }
        return ",";
    }

    static String trimInput(String input) {
        return "";
    }
}