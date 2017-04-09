package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculator.
 *
 * @author Kirill Alekseev
 * @version $Id$
 * @since 0.1
 */

public class CalculatorTest {

    /**
    * Тестируем сложение.
    */
    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        calc.add(5d, 5d);
        double resultAdd = calc.getResult();
        double expected = 10d;
        assertThat(resultAdd, is(expected));
    }

    /**
    * Тестируем вычетание.
    */
    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        calc.subtract(5d, 5d);
        double resultSubtract = calc.getResult();
        double expected = 0d;
        assertThat(resultSubtract, is(expected));
    }

    /**
    * Тестируем деление.
    */
    @Test
    public void testDiv() {
        Calculator calc = new Calculator();
        calc.Div(5d, 5d);
        double resultDiv = calc.getResult();
        double expected = 1d;
        assertThat(resultDiv, is(expected));
    }


}
