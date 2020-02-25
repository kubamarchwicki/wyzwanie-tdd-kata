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

    /**
     * The test is a candidate to be deleted as task 2 introduces multiple parameters, to sum.
     */
    //@Test
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
    public void should_return_0_for_string_null() {
        Calculator calculatorUnderTest = new Calculator();

        int result = calculatorUnderTest.add(null);

        assertThat(result, equalTo(0));
    }

    @Test
    public void should_return_1_for_1() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_3_for_12() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_3_for_provided_input() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[;]\n1;2";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(3));
    }

    @Test
    public void should_return_15_for_provided_input() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2,3,4,5";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(15));
    }

    @Test
    public void should_return_55_for_provided_multipla_input() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2,3,4,5,6,7,8,9,10";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(55));
    }

    @Test
    public void should_return_55_for_longSeparator() {
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[longSeparator]\n1longSeparator2longSeparator3longSeparator4longSeparator5longSeparator6longSeparator7longSeparator8longSeparator9longSeparator10";

        int result = calculatorUnderTest.add(input);

        assertThat(result, equalTo(55));
    }

}