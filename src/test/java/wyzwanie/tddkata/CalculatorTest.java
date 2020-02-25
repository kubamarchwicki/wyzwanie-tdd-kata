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
    public void should_return_6_for_123(){
        Calculator calculatorUnderTest = new Calculator();
        String input = "123";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(123));
    }

    @Test
    public void should_return_6_for_123_with_commas(){
        Calculator calculatorUnderTest = new Calculator();
        String input = "12,3";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(15));
    }



}