package wyzwanie.tddkata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;

public class CalculatorInputFilterTest {

    @Test
    public void should_return_true_for_number() {
        //given
        String input = "14";

        //when
        boolean result = CalculatorInputFilter.isNumeric(input);

        //then
        assertTrue(result);
    }

    @Test
    public void should_return_false_for_empty() {
        //given
        String input = "";

        //when
        boolean result = CalculatorInputFilter.isNumeric(input);

        //then
        assertFalse(result);
    }

    @Test
    public void should_filter_input_from_alphabetic_chars() {
        //given
        String input = "1a2b3ccc";

        //when
        String result = CalculatorInputFilter.removeAlphabeticChars(input);

        //then
        assertEquals(result, "123");
    }

    @Test
    public void should_return_true_for_non_numeric_char() {
        //given
        String input = "12;3";

        //when
        boolean result = CalculatorInputFilter.containsNonNumericChars(Arrays.asList(input));

        //then
        assertTrue(result);
    }

}
