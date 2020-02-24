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
    public void should_return_six_for_123() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2,3";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(6));
    }

    @Test
    public void should_return_two_for_2() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "2";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(2));
    }

    @Test(expected = NumberFormatException.class)
    public void should_return_throw_when_try_add_negative_number() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "2,-5";

        Integer result = calculatorUnderTest.add(input);
    }

}