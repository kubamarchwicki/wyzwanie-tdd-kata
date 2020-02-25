package wyzwanie.tddkata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CalculatorInput {

    private static final String DEFAULT_SEPARATORS = "[,]";

    private final List<String> numbers;

    private final String separator;

    public CalculatorInput(String input) {
        if (input == null) {
            separator = DEFAULT_SEPARATORS;
            numbers = new ArrayList<>();
        } else {
            String[] split = input.split("\n");
            String numberString;

            if (split.length > 1) {
                separator = customSeparator(input);
                numberString = split[1];
            } else {
                separator = DEFAULT_SEPARATORS;
                numberString = split[0];
            }

//            validSeparatorBetweenNumbers(numberString);
            numbers = Arrays.asList(numberString.split(separator));
        }
    }

    private String customSeparator(String input) {
        int start = input.indexOf("[");
        int end = input.indexOf("]");
        return input.substring(start, end+1);
    }

//    private void validSeparatorBetweenNumbers(String numberString) {
//        if (numberString.trim().length() > 1 && !numberString.contains(separator)) {
//            throw new IllegalArgumentException("Wrong input delimiter");
//        }
//    }

    public List<String> getNumbers() {
        return numbers;
    }

    public String getSeparator() {
        return separator;
    }

}
