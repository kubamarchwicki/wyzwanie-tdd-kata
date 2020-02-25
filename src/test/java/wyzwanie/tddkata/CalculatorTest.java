package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_zero_for_null_input() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = null;

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_self_for_a_single_number() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "42";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(42));
    }

    @Test
    public void should_return_sum_for_two_numbers() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "7,11";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(18));
    }

    @Test
    public void should_ignore_non_numbers_and_sum_rest() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "a,3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_no_comma_as_delimeter() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1;3";

        //when
        Integer result = calculatorUnderTest.add(input);
    }

    @Test
    public void should_return_three_for_comma_at_end() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String threeComma = "3,";

        //when
        Integer result = calculatorUnderTest.add(threeComma);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_sum_for_five_numbers() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2,3,4,5";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(15));
    }

    @Test
    public void should_return_sum_for_three_numbers_delim_semicolon() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[;]\n1;2";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_sum_for_five_numbers_delim_semicolon() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[;]\n1;2;3;4;5";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(15));
    }

    @Test
    public void should_return_sum_using_default_delimiter_when_change_delim_line_is_not_correct() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[]\n1,2";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(3));
    }

}