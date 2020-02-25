package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void should_return_error_when_no_comma_as_delimeter() {
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
    public void should_sum_only_first_two_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(5));
    }
    @Test
    public void multiple_numbers(){
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "0,3,5,2";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(10));

    }
    @Test
    public void change_delimery(){
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[!@#$%&*()_+=|<>?{}\\[\\]~-]\n5-!4*5,";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(14));
    }
    @Test
    public void error_when_mentioned_delimery_doesnt_exist() {
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "//[b]\n4*5,";
        String [] separator = multipleInput.split("\n");
         //when
        Integer result = calculatorUnderTest.add(multipleInput);
        //then
        assertFalse(separator[1].contains("b"));
    }
    @Test
    public void error_when_delimery_syntax_has_missing_slash(){
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "/[b]\n4*5,";
        String [] separator = multipleInput.split("\n");
        //when
        Integer result = calculatorUnderTest.add(multipleInput);
        //then
        assertFalse(separator[0].contains("//[b]"));
    }

    }


