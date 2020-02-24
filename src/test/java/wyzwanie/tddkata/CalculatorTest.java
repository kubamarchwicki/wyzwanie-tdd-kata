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
    public void should_return_two_for_2(){
        Calculator calculatorUnderTest = new Calculator();
        String input = "2";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(2));
    }
    @Test
    public void should_return_five_for_23(){
        Calculator calculatorUnderTest = new Calculator();
        String input = "2,3";

        Integer result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(5));
    }
}