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
    public void should_return_parameter_when_single_parameter_present() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneInput = "2";

        //when
        Integer result = calculatorUnderTest.add(oneInput);

        //then
        assertThat(result, equalTo(2));
    }

    @Test
    public void should_return_correct_adding_solution() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "2,10";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(12));
    }

    @Test
    public void should_return_error_message_when_more_than_two_parameters_present() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,2,2";

        //when
        calculatorUnderTest.add(multipleInput);

        //then
        // ???
    }

}