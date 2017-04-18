package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Counter.
* @author Kirill Alekseev
* @version $Id$
* @since 0.1
*/

 public class CounterTest {
/**
* Тест суммирования четных чисел в пределах заданного диапазона.
*/

@Test
     public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
     }
 }
