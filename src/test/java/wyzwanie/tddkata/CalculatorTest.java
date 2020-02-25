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
    public void should_return_one_value_for_3(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneNumber = "3";

        //when
        Integer result = calculatorUnderTest.add(oneNumber);

        //then

        assertThat(result, equalTo(3));

    }

    @Test
    public void should_return_seven_for_34(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String twoNumbers = "3,4";

        //when
        Integer result = calculatorUnderTest.add(twoNumbers);

        //then

        assertThat(result, equalTo(7));

    }
}