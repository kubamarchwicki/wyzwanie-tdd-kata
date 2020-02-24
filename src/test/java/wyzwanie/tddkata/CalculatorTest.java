package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    private Calculator calculatorUnderTest = new Calculator();
    private String input;
    private Integer result;

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        input = "";
        //when
        result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_one_for_1_string() {
        //given
        input = "1";
        //when
        result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_three_for_12_string() {
        //given
        input = "1,2";
        //when
        result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(3));
    }
}