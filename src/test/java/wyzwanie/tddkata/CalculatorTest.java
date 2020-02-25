package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator calculatorUnderTest = new Calculator();

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        String input = "";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_zero_for_null_input(){
        //given
        String input = null;
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result,equalTo(0));
    }

    @Test
    public void should_return_one_for_1_string() {
        //given
        String input = "1";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_three_for_12_string() {
        //given
        String input = "1,2";
        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(3));
    }

//    @Test
//    public void should_sum_only_first_two_numbers() {
//        //given
//        String input = "1,2,3";
//        //when
//        Integer result = calculatorUnderTest.add(input);
//        //then
//        assertThat(result, equalTo(3));
//    }

    @Test
    public void should_return_self_for_a_single_number() {
        //given
        String input = "55";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(55));
    }

    @Test
    public void should_return_correct_sum_for_two_numbers(){
        //given
        String input = "1,10";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(11));
    }

    @Test
    public void should_return_three_for_comma_at_the_end() {
        //given
        String input = "3,";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }
    @Test
    public void should_return_three_for_comma_at_the_beginning() {
        //given
        String input = ",3";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(3));
    }

    @Test
    public void should_ignore_non_number_input_and_sum_only_numbers(){
        //given
        String input = "a,2,1";

        //when
        Integer result = calculatorUnderTest.add(input);
        //then
        assertThat(result, equalTo(3));
    }

    @Test(expected = Exception.class)
    public void should_return_error_when_no_comma_as_delimiter() {
        //given
        String input = "1;3";

        //when
        Integer result = calculatorUnderTest.add(input);
    }


}