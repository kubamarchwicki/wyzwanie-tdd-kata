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
    public void should_return_5_for_5() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "5";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(5));
    }

    @Test
    public void should_return_10_for_46() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "4,6";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(10));
    }

}