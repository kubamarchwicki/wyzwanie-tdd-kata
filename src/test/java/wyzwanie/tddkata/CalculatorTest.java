package wyzwanie.tddkata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

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
  public void should_return_one_when_one_given() {
    // given

    Calculator calculatorUnderTest = new Calculator();
    String parameter = "1";

    // when
    Integer result = calculatorUnderTest.add(parameter);

    //then
    assertThat(1, equalTo(result));
  }

  @Test
  public void should_return_zero_when_zero_given() {
    // given

    Calculator calculatorUnderTest = new Calculator();
    String parameter = "0";

    // when
    Integer result = calculatorUnderTest.add(parameter);

    //then
    assertThat(0, equalTo(result));
  }

  @Test
  public void should_return_zero_when_two_zeros_given() {
    // given

    Calculator calculatorUnderTest = new Calculator();
    String parameter = "0,0";

    // when
    Integer result = calculatorUnderTest.add(parameter);

    //then
    assertThat(0, equalTo(result));
  }

  @Test
  public void should_return_three_when_one_and_two_given() {
    // given

    Calculator calculatorUnderTest = new Calculator();
    String parameter = "1,2";

    // when
    Integer result = calculatorUnderTest.add(parameter);

    //then
    assertThat(3, equalTo(result));
  }

    @Test
    public void should_return_six_when_123_given() {
        // given

        Calculator calculatorUnderTest = new Calculator();
        String parameter = "1,2,3";

        // when
        Integer result = calculatorUnderTest.add(parameter);

        //then
        assertThat(6, equalTo(result));
    }
}