package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorHelperTest {

    @Test
    public void should_return_comma_as_default_delimiter_when_input_is_empty() {
        
        //given
        String input = "";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo(","));
    }
    
    @Test
    public void should_return_comma_as_default_delimiter() {
        
        //given
        String input = "1,2,3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo(","));
    }

    @Test
    public void should_return_comma_as_delimiter_when_delimiter_not_defined() {
        
        //given
        String input = "//[]\n3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo(","));
    }

    @Test
    public void should_return_comma_as_delimiter_when_lack_of_closing_tag() {
        
        //given
        String input = "//[n3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo(","));
    }

    @Test
    public void should_return_comma_as_delimiter_when_closing_tag_is_at_the_begining() {
        
        //given
        String input = "]\n;//[3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo(","));
    }

    @Test
    public void should_return_one_character_as_delimiter() {
        
        //given
        String input = "//[a]\n3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo("a"));
    }

    @Test
    public void should_return_many_characters_as_delimiter() {
        
        //given
        String input = "//[baba]\n3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
        
        //then
        assertThat(delimiter, equalTo("baba"));
    }

    @Test(expected = Exception.class)
    public void should_throw_exception_when_delimiter_is_number() {
        
        //given
        String input = "//[123]\n3";

        //when
        String delimiter = CalculatorHelper.findDelimiter(input);
    }

}