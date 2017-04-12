package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Max Number.
 *
 * @author Kirill Alekseev
 * @version $Id$
 * @since 0.1
 */

public class MaxTest {

/**
Тест №1 -  возврщает первое число если оно больше второго.
*/

    @Test
    public void maxNumberOne() {
        Max max = new Max();
        final int first = 12;
        final int second = 10;
        assertThat(max.findMaxNumber(first, second), is(first));

}

/**
Тест №2 -  возврщает второе число если оно больше первого.
*/

    @Test
    public void maxNumberTwo() {
        Max max = new Max();
        final int first = 10;
        final int second = 12;
        assertThat(max.findMaxNumber(first, second), is(second));

}

/**
Тест №3 -  возврщает первое число если числы равны.
*/

    @Test
    public void maxNumberThree() {
        Max max = new Max();
        final int first = 10;
        final int second = 10;
        assertThat(max.findMaxNumber(first, second), is(first));

}

}
