package wyzwanie.tddkata;

import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

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
    public void should_return_provided_string(){
        //given
        Calculator calculatorUnderTest = new Calculator();
        String providedString = "3";

        //when
        Integer result = calculatorUnderTest.add(providedString);

        //then
        assertThat(result, equalTo(3));

    }

}