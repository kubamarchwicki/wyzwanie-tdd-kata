package wyzwanie.tddkata;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NegativeNotAllowedTest {

    private final static String EXCEPTION_MESSAGE = "NegativeNotAllowed(\"%\")";

    @Test
    public void should_throw_exception() throws NegativeNotAllowed {
        Exception exception = assertThrows(NegativeNotAllowed.class,
                () -> {throw new NegativeNotAllowed("");});

        assertThat(exception.getMessage(),
                equalTo(EXCEPTION_MESSAGE.replace("%", "")));
    }

    @Test
    public void should_return_exception_with_message_minus_5()  {
        //given
        String input = "-5";

        //when
        Exception exception = assertThrows(NegativeNotAllowed.class,
                () -> {throw new NegativeNotAllowed(input);});
        //then

        assertThat(exception.getMessage(),
                equalTo(EXCEPTION_MESSAGE.replace("%", "-5")));
    }

    @Test
    public void should_return_exception_with_message_minus_10_coma_minus_3()  {
        //given
        String input = "-10, -3";

        //when
        Exception exception = assertThrows(NegativeNotAllowed.class,
                () -> {throw new NegativeNotAllowed(input);});
        //then
        assertThat(exception.getMessage(),
                equalTo(EXCEPTION_MESSAGE.replace("%", "-10, -3")));
    }

}
