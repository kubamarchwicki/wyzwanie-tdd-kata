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
    public void should_return_six_for_123(){
        Calculator calculatorUnderTest = new Calculator();
        String input = "1,2,3";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result, equalTo(6));
    }
    @Test
    public void should_return_six_for_123_dot_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1.2.3";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(6));
    }
    @Test
    public void should_return_six_for_123_two_dots_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1..2..3";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(6));
    }
    @Test
    public void should_return_six_for_123_dot_and_coma_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1.,2.,3";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(6));
    }
    @Test
    public void should_return_45_for_123456789_two_dots_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1..2..3..4..5..6..7..8..9";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(45));
    }
    @Test
    public void should_return_45_for_123456789_dot_and_coma_mix_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1.,2..3,.4..5,.6..7,.8..9";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(45));
    }
    @Test
    public void should_return_45_for_123456789_dot_and_coma_mix_length_separator(){
        Calculator calculatorUnderTest = new Calculator();
        String input ="1.,2.,,,,,,.3,.4.,,,,,.5,.6.......7,.8.,,,,,,.9";
        Integer result = calculatorUnderTest.add(input);
        assertThat(result,equalTo(45));
    }
}