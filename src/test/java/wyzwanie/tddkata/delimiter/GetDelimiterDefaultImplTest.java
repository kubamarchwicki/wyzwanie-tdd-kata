package wyzwanie.tddkata.delimiter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class GetDelimiterDefaultImplTest {

    @Test
    public void should_return_semicolon() {
        GetDelimiterDefaultImpl getDelimiter = new GetDelimiterDefaultImpl();

        String result = getDelimiter.getDelimiterFromInput("//[;]\n1;2");

        assertThat(result, equalTo(";"));
    }

    @Test
    public void should_return_comma() {
        GetDelimiterDefaultImpl getDelimiter = new GetDelimiterDefaultImpl();

        String result = getDelimiter.getDelimiterFromInput("1;2");

        assertThat(result, equalTo(","));
    }

    @Test
    public void should_return_comma_for_null() {
        GetDelimiterDefaultImpl getDelimiter = new GetDelimiterDefaultImpl();

        String result = getDelimiter.getDelimiterFromInput(null);

        assertThat(result, equalTo(","));
    }

    @Test
    public void should_return_comma_for_empty_string() {
        GetDelimiterDefaultImpl getDelimiter = new GetDelimiterDefaultImpl();

        String result = getDelimiter.getDelimiterFromInput("");

        assertThat(result, equalTo(","));
    }

}