package wyzwanie.tddkata;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


public class CalculatorTest {

    private Calculator calculatorUnderTest;

    @Before
    public void init(){
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
    public void should_return_provided_numbers(){
        //given
        String providedNumber = "3";

        //when
        Integer result = calculatorUnderTest.add(providedNumber);

        //then
        assertThat(result, equalTo(3));

    }

    @Test
    public void should_return_sum_of_two_numbers_divided_by_comma(){
        //given
        String providedTwoNumbersDividedByComma = "2,3";

        //when
        Integer result = calculatorUnderTest.add(providedTwoNumbersDividedByComma);

        //then
        assertThat(result, equalTo(5));

    }

}