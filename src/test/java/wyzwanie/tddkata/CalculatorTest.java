package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    public String delimitter = ",";
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
    public void return_one_number(){
        //given
        Calculator calculatorUnderTest = new Calculator();
        String str = "11";
        
        //when
        Integer result = calculatorUnderTest.add(str);
        
        //then
        assertThat(result, equalTo(11));
    }

    @Test
    public void return_sum_of_more_numbers(){
        //given
        Calculator calculatorUnderTest = new Calculator();
        String str = "1,2,3";

        //when
        Integer result = calculatorUnderTest.add(str);
        
        //then
        assertThat(result, equalTo(6));
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
    public void change_delimitter(){
        //given
        Calculator calculatorUnderTest = new Calculator();
        String str = "//[;]\n1;2";
        
        //when
        Integer result = calculatorUnderTest.add(str);

        //then
        assertThat(result, equalTo(3));
    }

}
