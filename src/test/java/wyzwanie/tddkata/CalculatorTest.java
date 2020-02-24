package wyzwanie.tddkata;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    public void should_return_zero_for_empty_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String emptyString = "";

        //when
        int result = calculatorUnderTest.add(emptyString);

        //then
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_one_for_1_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String one = "1";

        //when
        int result = calculatorUnderTest.add(one);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_3_for_12_string() {
        //given
        Calculator calculatorUnderTest = new Calculator();
        String one = "1,2";

        //when
        int result = calculatorUnderTest.add(one);

        //then
        assertThat(result).isEqualTo(3);
    }
}