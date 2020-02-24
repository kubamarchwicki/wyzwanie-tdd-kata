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
    public void oneParameterShouldReturnHisValue(){
        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneParameter="2";
        //when
        Integer output = calculatorUnderTest.add(oneParameter);
        //then
        assertThat(output, equalTo(2));
    }

    @Test
    public void twoParametersShouldReturnSumOfThem(){
        //give
        Calculator calculatorUnderTest = new Calculator();
        String twoParameters ="1,2";
        //when
        Integer output = calculatorUnderTest.add(twoParameters);
        //then
        assertThat(output,equalTo(3));
    }

}