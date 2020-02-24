package wyzwanie.tddkata;

import org.junit.Test;

import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
    public void should_return_five(){
    Calculator calculatorUnderTest = new Calculator();
    String five = "1,2,2";

    Integer result = calculatorUnderTest.add(five);
    assertThat(result,equalTo(5));
    }

    @Test
    public void number_of_inputs(){
        Calculator calculatorUnderTest = new Calculator();
        String three = "1,2,3";
        String[] parts = three.split(",");
        int size = parts.length;
        assertThat(size,equalTo(3));
    }

    @Test
    public void special_charters(){
        Calculator calculatorUnderTest = new Calculator();
        String comma = "1.2";
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        assertTrue(comma.contains(","));
        assertFalse(comma.contains("[!@#$%&*()_+=|<>?{}\\[\\]~-]"));

    }

}