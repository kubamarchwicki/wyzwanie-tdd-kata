package wyzwanie.tddkata;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NegativeNotAllowedTest {

    private final static String EXCEPTION_MESSAGE = "NegativeNotAllowed(\"%\")";

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = NegativeNotAllowed.class)
    public void should_throw_exception() throws NegativeNotAllowed {
        throw new NegativeNotAllowed("");
    }

    @Test
    public void should_return_exception_with_message_minus_5()  {
        //given
        String input = "-5";

        //when
        try {
            throw new NegativeNotAllowed(input);
        }
        //then
        catch(NegativeNotAllowed e){
            assertThat(e.getMessage(), equalTo(EXCEPTION_MESSAGE.replace("%", "-5")));
        }
    }

    @Test
    public void should_return_exception_with_message_minus_10_coma_minus_3()  {
        //given
        String input = "-10, -3";

        //when
        try {
            throw new NegativeNotAllowed(input);
        }
        //then
        catch(NegativeNotAllowed e){
            assertThat(e.getMessage(), equalTo(EXCEPTION_MESSAGE.replace(
                    "%", "-10, -3")));
        }
    }

}
