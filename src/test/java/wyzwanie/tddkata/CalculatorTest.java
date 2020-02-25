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

    @Test(expected = Exception.class)
    public void should_return_error_when_no_comma_as_delimeter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "1;3";

        //when
        Integer result = calculatorUnderTest.add(input);
    }

    @Test
    public void should_sum_first_ten_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "1,2,3,4,5,6,7,8,9,10";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(55));
    }

    @Test
    public void should_sum_numbers_with_semicolon_as_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[;]\n1;2;3;4;5";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(15));
    }

    @Test
    public void should_sum_numbers_with_colon_as_delimiter() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[:]\n1:2:3:4:5";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(15));
    }

    @Test(expected = Exception.class)
    public void should_throw_exception_if_delimiters_do_not_match() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[;]\n1:2:3:4:5";

        //when
        calculatorUnderTest.add(multipleInput);
    }

    @Test(expected = Exception.class)
    public void should_throw_exception_if_delimiter_declaration_is_malformed() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "!@$;]\n1:2:3:4:5";

        //when
        calculatorUnderTest.add(multipleInput);
    }

    @Test(expected = Exception.class)
    public void should_throw_exception_if_delimiter_content_is_malformed() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[;]\n1::2:3:4:5";

        //when
        calculatorUnderTest.add(multipleInput);
    }
}