package wyzwanie.tddkata;

import org.junit.Ignore;
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

    @Ignore
    @Test
    public void should_sum_only_first_two_numbers() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(5));
    }

    @Test
    public void should_sum_numbers_with_new_delimeter() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[;]\n1;2";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_sum_numbers_with_new_delimeter_and_random_values() throws Exception {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[;]\njhagh;2;fua7;ufhsa98;;;fsh;3";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(5));
    }
}