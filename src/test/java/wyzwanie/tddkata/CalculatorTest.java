package wyzwanie.tddkata;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    Calculator sut = new Calculator();

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        String emptyString = "";

        //when
        Integer result = sut.add(emptyString);

        //then
        assertThat(result, equalTo(0));
    }


    @Test
    public void should_return_given_value_for_one_argument() {
        // given
        String oneArgument = "2";

        // when
        Integer actual = sut.add(oneArgument);

        // then
        assertThat(actual, equalTo(Integer.parseInt(oneArgument)));
    }

    @Test
    public void should_return_sum_of_two_arguments_for_2_arguments_with_separator() {
        // given
        String twoArguments = "1,2";

        // when
        Integer actual = sut.add(twoArguments);

        // then
        assertThat(actual, equalTo(3));
    }

    @Test
    public void should_return_sum_of_two_arguments_for_2_arguments_separated_a_space() {
        // given
        String twoArgumentsWithSpace = "1 2";

        // when
        Integer actual = sut.add(twoArgumentsWithSpace);

        // then
        assertThat(actual, equalTo(3));
    }


    @Test
    public void should_return_sum_of_any_number_of_arguments() {
        // given
        String manyArguments = "1,2,3,4,5,6,7,8,9,0";

        // when
        Integer actual = sut.add(manyArguments);

        // then
        assertThat(actual, equalTo(45));
    }

    @Test
    @Ignore
    public void should_return_sum_of_any_number_of_arguments_with_any_number_of_comma_characters() {
        // given
        String twoArguments = "1,2-0,4!@#$%^&*()_+-=[]{};:'\"\\|,.<>?/~`353454         2353245324";

        // when
        Integer actual = sut.add(twoArguments);

        // then
        assertThat(actual, equalTo(64));
    }

}