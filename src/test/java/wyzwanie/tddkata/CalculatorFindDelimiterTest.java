package wyzwanie.tddkata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorFindDelimiterTest {

    @ParameterizedTest
    @MethodSource
    public void calculatorHelper_should_find_delimiter(String input, String expectedResult) {
        //given

        //when
        String delimiter = Calculator.findDelimiter(input);

        //then
        assertThat(delimiter, equalTo(expectedResult));
    }

    private static Stream<Arguments> calculatorHelper_should_find_delimiter() {
        return Stream.of(
            Arguments.of("", ","),
            Arguments.of("42", ","),
            Arguments.of("7,11", ","),
            Arguments.of("//[]\n3", ","),
            Arguments.of("//[n3", ","),
            Arguments.of("]\n;//[3", ","),
            Arguments.of("//[a]\n3", "a"),
            Arguments.of("//[baba]\n3", "baba")
        );
    }


    @Test
    public void should_throw_exception_when_delimiter_is_number() {
        
        //given
        String input = "//[123]\n3";

        //when
        Assertions.assertThrows(Exception.class, () -> Calculator.findDelimiter(input));
    }

}