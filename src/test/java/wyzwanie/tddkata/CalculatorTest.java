package wyzwanie.tddkata;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotEquals;
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
    public void should_return_five_for_string_5() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String five = "5";

        //when
        Integer result = calculatorUnderTest.add(five);

        //then
        assertThat(result, equalTo(5));
    }

    @Test
    public void should_return_twenty_for_string_20() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String twenty = "20";

        //when
        Integer result = calculatorUnderTest.add(twenty);

        //then
        assertThat(result, equalTo(20));
    }

    @Test
    public void should_not_return_zero_for_string_6() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String six = "6";

        //when
        Integer result = calculatorUnderTest.add(six);

        //then
        assertThat(result, not(0));
    }

    @Test
    public void should_return_eleven_for_string_8_comma_3() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String eightCommaThree = "8,3";

        //when
        Integer result = calculatorUnderTest.add(eightCommaThree);

        //then
        assertThat(result, equalTo(11));
    }

    @Test
    public void should_return_fifty_eight_for_string_37_comma_21() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String thirtySevenCommaTwentyOne = "37,21";

        //when
        Integer result = calculatorUnderTest.add(thirtySevenCommaTwentyOne);

        //then
        assertThat(result, equalTo(58));
    }

    @Test
    public void should_not_return_zero_for_string_4_comma_5() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String fourCommaFive = "4,5";

        //when
        Integer result = calculatorUnderTest.add(fourCommaFive);

        //then
        assertThat(result, not(0));
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
    public void should_not_return_five_for_string_five() {
        // TODO: Need consulting about the output
        //given
        Calculator calculatorUnderTest = new Calculator();
        String fiveString = "five";

        //when
        Integer result = calculatorUnderTest.add(fiveString);

        //then
        assertThat(result, not(5));
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
    public void should_sum_all_numbers() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String multipleInput = "2,3,4";

        //when
        Integer result = calculatorUnderTest.add(multipleInput);

        //then
        assertThat(result, equalTo(9));
    }

    @Test
    public void should_return_one_for_dot_delimiter_and_one() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[.]\n1";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_four_for_a_delimiter_and_four_a() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[a]\n4a";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(4));
    }


    @Test
    public void should_return_twelve_for_semicolon_delimiter_and_three_semicolon_nine() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[;]\n3;9";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(12));
    }

    @Test
    public void should_return_six_for_3_delimiter_and_four_3_two() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[3]\n432";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(6));
    }

    @Test
    public void should_return_fifteen_for_comma_delimiter_and_five_comma_ten() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[,]\n5,10";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(15));
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void should_return_exception_for_five_coma_minus_five() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "5,-5";
        exceptionRule.expect(NegativeNotAllowed.class);
        exceptionRule.expectMessage("NegativeNotAllowed(\"-5\")");

        //when
        Integer result = calculatorUnderTest.add(input);
    }

    @Test
    public void should_return_exception_for_minus_two() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "-2";
        exceptionRule.expect(NegativeNotAllowed.class);
        exceptionRule.expectMessage("NegativeNotAllowed(\"-2\")");

        //when
        Integer result = calculatorUnderTest.add(input);

    }

    @Test
    public void should_return_exception_for_colon_delimiter_and_three_colon_minus_four_colon_six() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "//[:]\n3:-4:6";
        exceptionRule.expect(NegativeNotAllowed.class);
        exceptionRule.expectMessage("NegativeNotAllowed(\"-4\")");

        //when
        Integer result = calculatorUnderTest.add(input);

    }

    @Test
    public void should_return_exception_for_minus_two_coma_one_come_minus_nine() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String input = "-2,1,-9";
        exceptionRule.expect(NegativeNotAllowed.class);
        exceptionRule.expectMessage("NegativeNotAllowed(\"-2, -9\")");

        //when
        Integer result = calculatorUnderTest.add(input);

    }

    @Test
    public void should_return_sixteen_for_nine_coma_upperlimit_with_one_coma_seven() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        int upperlimit = Calculator.UPPER_LIMIT;
        String input = "9,"+(upperlimit+1)+",7";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(16));
    }

    @Test
    public void should_return_zero_for_upperlimit_with_two() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        int upperlimit = Calculator.UPPER_LIMIT;
        String input = (upperlimit+2)+"";

        //when
        Integer result = calculatorUnderTest.add(input);

        //then
        assertThat(result, equalTo(0));
    }
}