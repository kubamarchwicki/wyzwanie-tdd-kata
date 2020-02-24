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
    public void should_return_same_string_for_one_number_passed() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_sum_of_the_passed_strings() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input1 = "1,2";

        //when
        Integer result = calculatorUnderTest.add(input1);

        //then
        assertThat(result, equalTo(3));
    }

}