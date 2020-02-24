package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String emptyString = "";

        //when
        Integer result = calculatorUnderTest.add(emptyString);

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
    public void should_return_three_for_comma_at_end() {
        // TODO: Need consulting about the output
        //given
        Calculator calculatorUnderTest = new Calculator();
        String threeComma = "3,";

        //when
        Integer result = calculatorUnderTest.add(threeComma);

        //then
        assertThat(result, equalTo(3));
    }


}