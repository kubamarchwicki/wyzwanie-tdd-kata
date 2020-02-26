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
    public void should_return_zero_for_null_input() {
        //given
        String input = null;

        //when
        Integer result = calculatorUnderTest.add(input);

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

    @Test
    public void should_ignore_non_numbers_and_sum_rest() {
        //given
        String input = "a,2";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(2));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_no_comma_as_delimeter() {
        //given
        String input = "1;2";

        //when
        Integer result = calculatorUnderTest.add(input);

    }

    @Test
    public void should_return_three_for_comma_at_end() {
        //given
        String input = "3,";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }

//    @Test
//    public void should_sum_only_first_two_numbers() {
//        //given
//        String input = "2,3,4";
//
//        //when
//        Integer result = calculatorUnderTest.add(input);
//
//        //then
//        assertThat(result, equalTo(5));
//    }

    @Test
    public void should_return_sum_when_pattern_given() {
        //given
        String input = "//[:]\\n1:2:3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(6));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_one_negative_digit_in_the_middle(){
        //given
        String input = "//[;]\\n1;-2;3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(2));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_one_negative_digit_first(){
        //given
        String input = "//[;]\\n-2;2;3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_one_negative_digit_last(){
        //given
        String input = "//[;]\\n1;2;-3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_all_negative_digits(){
        //given
        String input = "//[;]\\n-1;-2;-3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(-6));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_one_number(){
        //given
        String input = "//[;]\\n1;100;3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(104));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_one_negative_number(){
        //given
        String input = "//[;]\\n1;-100;3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(-96));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_all_numbers(){
        //given
        String input = "//[;]\\n12;100;3000";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3112));
    }

    @Test
    public void should_return_sum_when_pattern_given_with_all_negative_numbers(){
        //given
        String input = "//[;]\\n-12;-100;-3000";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(-3112));
    }

    @Test
    public void should_return_sum_when_pattern_given_and_numbers_with_letters(){
        //given
        String input = "//[;]\\n-12;-100;h;-3000;a";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(-3112));
    }

    @Test
    public void should_return_zero_when_pattern_given_all_letters(){
        //given
        String input = "//[;]\\nd;a;c;b";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_five_when_pattern_given_only_five_first_only_letter_last(){
        //given
        String input = "//[;]\\n5;d";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(5));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_pattern_given_wrong_delimeter(){
        //given
        String input = "//[;]\\n5,d,10";

        //when
        Integer result = calculatorUnderTest.add(input);

    }

    @Test
    public void should_return_five_when_pattern_given_only_one_delimeter_match(){
        //given
        String input = "//[;]\\n5;10,10";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(5));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_wrong_pattern_given(){
        //given
        String input = "//;]\\n5,d,10";

        //when
        Integer result = calculatorUnderTest.add(input);

    }



}