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
    public void should_return_zero_for_null_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String nullString = null;
        //when
        Integer result = calculatorUnderTest.add(nullString);
        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_2_for_2() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "2";
        //when
        Integer result = calculatorUnderTest.add(inputString);
        //then
        assertThat(result, equalTo(2));
    }

    @Test
    public void should_return_3_for_12() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "1,2";
        //when
        Integer result = calculatorUnderTest.add(inputString);
        //then
        assertThat(result, equalTo(3));
    }



}