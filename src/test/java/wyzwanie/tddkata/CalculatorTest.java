package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String emptyString = "";

        //when
        Integer result = calculatorUnderTest.add(emptyString);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_zero_for_null() {
        //given
        Calculator calculatorUnderTest = new Calculator();

        //when
        Integer result = calculatorUnderTest.add(null);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_zero_for_string_with_only_separator() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String emptyString = ",";

        //when
        Integer result = calculatorUnderTest.add(emptyString);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_ignor_not_numbers_for_string_with_text_and_number() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String emptyString = "aga, 1";

        //when
        Integer result = calculatorUnderTest.add(emptyString);

        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_number_when_only_one_number_is_provided() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneString = "3";

        //when
        Integer result = calculatorUnderTest.add(oneString);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_five_when_one_and_four_numbers_are_provided() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneString = "1, 4";

        //when
        Integer result = calculatorUnderTest.add(oneString);

        //then
        assertThat(result, equalTo(5));
    }
}