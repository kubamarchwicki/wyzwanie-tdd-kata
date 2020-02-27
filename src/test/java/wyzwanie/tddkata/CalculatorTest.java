package wyzwanie.tddkata;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculatorTest {


    //Task 1

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
    public void should_return_one_value_for_3(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String oneNumber = "3";

        //when
        Integer result = calculatorUnderTest.add(oneNumber);

        //then

        assertThat(result, equalTo(3));

    }

    @Test
    public void should_return_seven_for_34(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String twoNumbers = "3,4";

        //when
        Integer result = calculatorUnderTest.add(twoNumbers);

        //then

        assertThat(result, equalTo(7));

    }

    @Test
    public void should_return_0_for_null(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String nullInput = null;

        //when
        Integer result = calculatorUnderTest.add(nullInput);

        //then

        assertThat(result, equalTo(0 ));

    }

    //Task 2

    @Test
    public void should_sum_numbers_with_delimiter(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String delimiterNumbersInput = "//[;]\n1; 4";

        //when
        Integer result = calculatorUnderTest.add(delimiterNumbersInput);

        //then

        assertThat(result, equalTo(5 ));

    }

    @Test (expected = IllegalArgumentException.class)
    public void should_return_error_for_incorrect_order(){

        //given
        Calculator calculatorUnderTest = new Calculator();
        String incorrectOderInput = "2;\n2;//[$]";

        //when
        Integer result = calculatorUnderTest.add(incorrectOderInput);

        //then

        assertThat(result, equalTo(4 ));

    }




}

/*

Zadanie 2. Dowolna ilość parametrów i różne separatory
Spraw by kalkulator przyjmował dowolną ilość parametrów i zwracał ich sumę.

Aby zmienić separator na inny niż domyślny należy podać w parametrach wejściowych
 nowy separator w poniższy sposób: //[delimiter]\n[numbers…​]

Pierwsza linia z separatorem jest opcjonalna

Poprzednia funkcjonalność powinna działać bez zmian.

Przykład: //[;]\n1;2 powinno zwrócić 3

*/