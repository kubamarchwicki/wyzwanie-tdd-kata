package wyzwanie.tddkata;

import org.junit.Test;

import java.util.Random;

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

        //when
        Integer result = calculatorUnderTest.add(null);

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
    public void should_sum_all_of_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(9));
    }

    @Test
    public void should_sum_two_numbers_separated_with_different_kind_of_delimiters() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String delimiters = Calculator.DELIMITERS;
        String input = "23".concat(delimiters).concat("23");

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(46));
    }

    @Test
    public void should_sum_random_number_of_numbers_separated_with_different_kind_of_delimiters() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String delimiters = Calculator.DELIMITERS;
        Random random = new Random();
        Integer randomNumber = random.nextInt(1000);
        String input = "";

        for (int i = 0; i < randomNumber; i++) {
            input += "7".concat(delimiters);
        }

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(7 * randomNumber));
    }


//    test is out of date, requirements have changed
//    @Test
//    public void should_sum_only_first_two_numbers() {
//        //given
//        Calculator calculatorUnderTest = new Calculator();
//        String multipleInput = "2,3,4";
//
//        //when
//        Integer result = calculatorUnderTest.add(multipleInput);
//
//        //then
//        assertThat(result, equalTo(5));
//    }

//    test is out of date, requirements have changed
//    @Test(expected = Exception.class)
//    public void should_return_error_when_no_comma_as_delimeter() {
//        //given
//        Calculator calculatorUnderTest = new Calculator();
//        String input = "1;3";
//
//        //when
//        Integer result = calculatorUnderTest.add(input);
//    }


}