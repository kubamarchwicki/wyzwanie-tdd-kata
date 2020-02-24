package wyzwanie.tddkata;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InputCheckerTest {

  @Test
  public void should_return_true_when_given_correct_number() {

    InputChecker inputCheckerUnderTest = new InputChecker();
    String inputNumber = "1";
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertThat(result, equalTo(true));
  }

  @Test
  public void should_return_true_when_given_0() {
    String inputNumber = "0";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertThat(result, equalTo(true));
  }

  @Test
  public void should_return_false_when_given_incorrect_number() {
    String inputNumber = "n";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertThat(result, equalTo(false));
  }

  @Test
  public void should_return_false_when_given_double() {
    String inputNumber = "1.0";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertThat(result, equalTo(false));
  }

  @Test
  public void should_replace_new_line_mark_with_comma() {
    String inputNumber = "1\n2";

    InputChecker inputCheckerUnderTest = new InputChecker();
    String[] result = inputCheckerUnderTest.replaceSeparatorsWithComma(inputNumber);

    assertArrayEquals(new String[]{"1", "2"}, result);

  }

  @Test
  public void should_replace_new_line_mark_and_comma_with_comma() {
    String inputNumber = "1\n,2";

    InputChecker inputCheckerUnderTest = new InputChecker();
    String[] result = inputCheckerUnderTest.replaceSeparatorsWithComma(inputNumber);

    assertArrayEquals(new String[]{"1", "2"}, result);

  }

  @Test
  public void should_replace_semicolon_with_comma() {
    String inputNumber = "1;2";

    InputChecker inputCheckerUnderTest = new InputChecker();
    String[] result = inputCheckerUnderTest.replaceSeparatorsWithComma(inputNumber);

    assertArrayEquals(new String[]{"1", "2"}, result);

  }

  @Test
  public void should_replace_colon_with_comma() {
    String inputNumber = "1:2";

    InputChecker inputCheckerUnderTest = new InputChecker();
    String[] result = inputCheckerUnderTest.replaceSeparatorsWithComma(inputNumber);

    assertArrayEquals(new String[]{"1", "2"}, result);

  }


  @Test
  public void should_replace_mixed_separator_with_comma() {
    String inputNumber = "1:2;3,4\n5\n,6";

    InputChecker inputCheckerUnderTest = new InputChecker();
    String[] result = inputCheckerUnderTest.replaceSeparatorsWithComma(inputNumber);

    assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, result);

  }

  @Test
  public void should_return_false_with_non_numeric_input() {
    String inputNumber = "1,2,a";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertFalse(result);

  }

  @Test
  public void should_return_true_with_numeric_input() {
    String inputNumber = "1,2,3";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertTrue(result);

  }
  @Test
  public void should_return_true_with_numeric_single_input() {
    String inputNumber = "1";

    InputChecker inputCheckerUnderTest = new InputChecker();
    boolean result = inputCheckerUnderTest.hasNumbersOnly(inputNumber);

    assertTrue(result);

  }
}
