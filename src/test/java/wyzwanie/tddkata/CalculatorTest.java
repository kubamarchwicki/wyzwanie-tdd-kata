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
        this.addMethodTest("", 0);
    }

    @Test
    public void should_return_one_for_string_equal_one() {
        this.addMethodTest("1", 1);
    }

    @Test
    public void should_return_ninety_nine_for_string_equal_ninety_nine() {
        this.addMethodTest("99", 99);
    }

    @Test
    public void should_return_three_for_string_equal_one_and_two_with_separator() {
        this.addMethodTest("1,2", 3);
    }

    @Test
    public void should_return_thirty_for_string_equal_five_and_ten_and_fifteen_with_separator() {
        this.addMethodTest("5,10,15", 30);
    }

    private void addMethodTest(String input, Integer expectedResult) {
        //when
        Integer actualResult = calculatorUnderTest.add(input);
        //then
        assertEquals(expectedResult, actualResult);
    }
}