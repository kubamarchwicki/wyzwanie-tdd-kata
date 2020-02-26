package wyzwanie.tddkata;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

class CalculatorInputDivider {

    private static final String DEFAULT_SEPARATOR = ",";

    private final List<String> numbers;

    private final String separator;

    public CalculatorInputDivider(String input) {
        if (input == null) {
            separator = DEFAULT_SEPARATOR;
            numbers = new ArrayList<>();
        } else {
            String[] split = input.split("\n");
            String numberString;

            if (split.length > 1) {
                separator = customSeparator(input);
                numberString = split[1];
            } else {
                separator = DEFAULT_SEPARATOR;
                numberString = split[0];
            }

            String filteredNumberString = CalculatorInputFilter.removeAlphabeticChars(numberString);
            numbers = asList(filteredNumberString.split(separator));
            findUndefinedDelimiters(numbers);
        }
    }

    private String customSeparator(String input) {
        int start = input.indexOf("[");
        int end = input.indexOf("]");

        try {
            return input.substring(start, end + 1);
        } catch (IndexOutOfBoundsException e) {
            return DEFAULT_SEPARATOR;
        }
    }

    private void findUndefinedDelimiters(List<String> numbers) {
        if (CalculatorInputFilter.containsNonNumericChars(numbers)) {
            throw new IllegalArgumentException("Undefined delimiter");
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public String getSeparator() {
        return separator;
    }

}
