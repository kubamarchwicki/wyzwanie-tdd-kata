package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_zero_for_null_input() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = null;

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_self_for_a_single_number() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "42";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(42));
    }

    @Test
    public void should_return_sum_for_two_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "7,11";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(18));
    }

    @Test
    public void should_ignore_non_numbers_and_sum_rest() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "a,3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_no_valid_delimeter_apper_in_given_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1;3";

        //when
        Integer result = calculatorUnderTest.add(input);
    }

    @Test
    public void should_return_three_for_comma_at_end() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String threeComma = "3,";

        //when
        Integer result = calculatorUnderTest.add(threeComma);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_sum_all_given_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(9));
    }

    @Test
    public void should_return_comma_as_default_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input_without_custom_delimiter = "2,3,4";

        //when  
    }

    @Test
    public void should_sum_all_given_numbers_with_empty_delimiter_declaration() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[]\n2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(9));
    } 

    @Test
    public void should_sum_all_given_numbers_with_custom_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[baba]\n2baba3baba4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(9));
    }

}