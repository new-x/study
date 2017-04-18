package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Factorial.
* @author Kirill Alekseev
* @version $Id$
* @since 0.1
*/

public class FactorialTest {
/**
* Тестируем вычесление факториала для значения 5.
*/
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
      Factorial factorial = new Factorial();
      int result = factorial.calc(5);
      int expected = 120;
      assertThat(result, is(expected));
    }
/**
* Тестируем вычесление факториала для значения 0.
*/
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
    Factorial factorial = new Factorial();
    int result = factorial.calc(0);
    int expected = 1;
    assertThat(result, is(expected));
    }
}
