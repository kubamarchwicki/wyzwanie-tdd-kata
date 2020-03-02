package wyzwanie.tddkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {

    private static Stream<Arguments> parametrizedPositives() {
        return Stream.of(
                Arguments.of("", 0), // should_return_zero_for_empty_string
                Arguments.of(null, 0), // should_return_zero_for_null_input
                Arguments.of("42", 42), // should_return_self_for_a_single_number
                Arguments.of("7,11", 18), // should_return_sum_for_two_numbers
                Arguments.of("a,3", 3), // should_ignore_non_numbers_and_sum_rest
                Arguments.of("3,", 3), // should_return_three_for_comma_at_end
                Arguments.of("2,3,4", 9), // should_sum_all_numbers
                Arguments.of("//[,]\n1,2,3", 6), // should_set_delimiter_coma
                Arguments.of("//[;]\n1;2;3", 6), // should_set_delimiter_to_non_default
                Arguments.of("//[aa]\n1aa2aa3", 6), // should_work_with_multicharacter_delimiter
                Arguments.of("//[test]\n1test2test3test", 6), // should_work_with_multicharacter_delimiter_and_delimiter_at_end
                Arguments.of("//[,]\n2000,2,500", 502), // should_ignore_bigger_than_1000
                Arguments.of("//[;]\n1;2;3000", 3) // should_ignore_bigger_than_1000
        );
    }

    private static Stream<Arguments> parametrizedExpectedExceptions() {
        return Stream.of(
                Arguments.of("1;3", Exception.class), // should_return_error_when_no_comma_as_delimiter
                Arguments.of("//[x]\n1y2", Exception.class), // should_return_error_when_wrong_custom_delimiter
                Arguments.of("//[;]\n1;-2;3", Calculator.NegativeNotAllowed.class) // should_return_error_when_negative_number
        );
    }

    @ParameterizedTest
    @MethodSource
    public void parametrizedPositives(String input, Integer expectedResult) throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(expectedResult));
    }

    @ParameterizedTest
    @MethodSource
    public void parametrizedExpectedExceptions(String input, Class<Exception> expectedException) {
        //given
        Calculator calculatorUnderTest = new Calculator();
        //when
        Assertions.assertThrows(expectedException, () -> calculatorUnderTest.add(input));
    }

    @Test
    public void should_return_negative_number_in_exception_message() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,-1";
        try {
            calculatorUnderTest.add(input);
            org.hamcrest.MatcherAssert.assertThat("Should throw exception up to here", false);
        } catch (Exception e) {
            assertThat(e.getMessage(), equalTo("-1"));
        }
    }


    @Test
    public void should_return_all_negative_numbers_in_exception_message() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,-1,-2,1,-3";
        try {
            calculatorUnderTest.add(input);
            org.hamcrest.MatcherAssert.assertThat("Should throw exception up to here", false);
        } catch (Exception e) {
            assertThat(e.getMessage(), equalTo("-1,-2,-3"));
        }
    }
}