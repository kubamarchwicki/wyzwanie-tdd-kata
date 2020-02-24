package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
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
    public void should_return_one_when_one_given() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "1";

        //when
        Integer result = calculatorUnderTest.add(inputString);

        //then
        assertThat(result, equalTo(1));
    }

    @Test
    public void should_return_six_when_adding_one_and_five() {
        // given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "1, 5";

        // when
        Integer result = calculatorUnderTest.add(inputString);

        // then
        assertThat(result, equalTo(6));
    }

    @Test
    public void should_return_twelve_when_adding_three_and_four_and_five() {
        // given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "3,4,5";

        // when
        Integer result = calculatorUnderTest.add(inputString);

        // then
        assertThat(result, equalTo(12));
    }

    @Test
    public void should_return_one_when_adding_negative_two_and_positive_three() {
        // given
        Calculator calculatorUnderTest = new Calculator();
        String inputString = "-2, 3";

        // when
        Integer result = calculatorUnderTest.add(inputString);

        // then
        assertThat(result, equalTo(1));
    }

}