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
    public void should_return_0_for_string_null() {
        Calculator calculatorUnderTest = new Calculator();

        int result = calculatorUnderTest.add(null);

        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_1_for_1() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_3_for_12() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(3));
    }

}