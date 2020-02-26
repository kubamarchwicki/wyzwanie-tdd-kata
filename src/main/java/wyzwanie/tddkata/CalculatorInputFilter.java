package wyzwanie.tddkata;

import java.util.List;

public class CalculatorInputFilter {

    public static boolean isNumeric(String num) {
        return !num.isEmpty()
            && num.chars().allMatch(Character::isDigit);
    }

    public static String removeAlphabeticChars(String numberString) {
        return numberString.replaceAll("[A-Za-z]", "");
    }

    public static boolean containsNonNumericChars(List<String> numbers) {
        return numbers.stream()
            .anyMatch(number -> !number.isEmpty() && !isNumeric(number));
    }

}
