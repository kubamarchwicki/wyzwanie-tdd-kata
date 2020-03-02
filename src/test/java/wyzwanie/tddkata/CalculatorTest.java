package wyzwanie.tddkata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @ParameterizedTest
    @MethodSource
    void calculator_should_add_numbers(String input, Integer expectedResult) {
        //given
        Calculator calculatorUnderTest = new Calculator();

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(expectedResult));
    }

    private static Stream<Arguments> calculator_should_add_numbers(){
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("5", 5),
                Arguments.of("20", 20),
                Arguments.of("8,3", 11),
                Arguments.of(null, 0),
                Arguments.of("a,3", 3),
                Arguments.of("3,", 3),
                Arguments.of("2,3,4", 9),
                Arguments.of("//[.]\n1", 1),
                Arguments.of("//[a]\n4a", 4),
                Arguments.of("//[;]\n3;9", 12),
                Arguments.of("//[3]\n432", 6),
                Arguments.of("//[,]\n5,10", 15),
                Arguments.of("9,"+(Calculator.UPPER_LIMIT+1)+",7", 16),
                Arguments.of(""+(Calculator.UPPER_LIMIT+2), 0),
                Arguments.of(""+(Calculator.UPPER_LIMIT)+",3", 1003),
                Arguments.of("//[ppp]\n6ppp1", 7),
                Arguments.of("//[,,,]\n3,,,", 3)
        );
    }

    @Test
    public void should_not_return_zero_for_string_6() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String six = "6";

        //when
        Integer result = calculatorUnderTest.add(six);

        //then
        assertThat(result, not(0));
    }

    @Test
    public void should_not_return_zero_for_string_4_comma_5() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String fourCommaFive = "4,5";

        //when
        Integer result = calculatorUnderTest.add(fourCommaFive);

        //then
        assertThat(result, not(0));
    }

    @Test
    public void should_not_return_five_for_string_five() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String fiveString = "five";

        //when
        Integer result = calculatorUnderTest.add(fiveString);

        //then
        assertThat(result, not(5));
    }

    @ParameterizedTest
    @MethodSource
    void calculator_should_return_negative_number_exception(String input, String expectedMessage) {
        //given
        Calculator calculatorUnderTest = new Calculator();

        //when
        Exception exception = assertThrows(NegativeNotAllowed.class,
                () -> calculatorUnderTest.add(input));

        //then
        assertThat(exception.getMessage(), equalTo(expectedMessage));
    }

    private static Stream<Arguments> calculator_should_return_negative_number_exception() {
        String expectedMessage = "NegativeNotAllowed(\"%s\")";
        return Stream.of(
                Arguments.of("5,-5", String.format(expectedMessage, "-5")),
                Arguments.of("-2", String.format(expectedMessage, "-2")),
                Arguments.of("//[:]\n3:-4:6", String.format(expectedMessage, "-4")),
                Arguments.of("-2,1,-9", String.format(expectedMessage, "-2, -9"))
        );
    }

    @Test
    public void should_return_error_when_no_comma_as_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1;3";

        //when
        assertThrows(Exception.class,
                () -> calculatorUnderTest.add(input));
    }
}