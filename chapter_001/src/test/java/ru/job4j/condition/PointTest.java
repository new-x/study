package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class PointTest - Условный оператор.
 * @author alekseev
 * @since 1.0
 */


public class PointTest {
/**
 * Тест.
 */
@Test
public void whenAisTwoBisFiveXisThreeYisEleven() {
        Point point = new Point(5, 32);
        boolean result = point.is(5, 7);
        boolean expected = true;
        assertThat(result, is(expected));
}
}
