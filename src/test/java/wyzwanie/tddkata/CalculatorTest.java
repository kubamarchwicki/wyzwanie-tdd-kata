package wyzwanie.tddkata;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
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

    @Test
    @Parameters({
            "1, 1",
            "15, 15",
            "999, 999"
    })
    public void should_return_the_same_for_one_string_without_separator(
            String input, Integer expectedResult) {
        //when
        Integer actualResult = calculatorUnderTest.add(input);

        //then
        assertEquals(expectedResult, actualResult);
    }
}