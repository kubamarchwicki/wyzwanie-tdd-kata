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
    public void should_return_given_number() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneNumberString = "10";

        //when
        Integer result = calculatorUnderTest.add(oneNumberString);

        //then
        assertThat(result, equalTo(10));
    }

    @Test
    public void should_return_sum_for_string_with_two_numbers_separated_by_comma() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String twoNumbersSeparatedByCommaString = "10,5";

        //when
        Integer result = calculatorUnderTest.add(twoNumbersSeparatedByCommaString);

        //then
        assertThat(result, equalTo(15));
    }

}