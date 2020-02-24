package wyzwanie.tddkata;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    Calculator calculatorUnderTest;

    @Before
    public void initCalculator() {
        calculatorUnderTest = new Calculator();
    }

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        String emptyString = "";

        //when
        Integer result = calculatorUnderTest.add(emptyString);

        //then
        assertThat(result, equalTo(0));
    }

}