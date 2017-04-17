package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

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
        Point point = new Point(1, 2);
        boolean result = point.is(1, 1);
        boolean expected = true;
        assertThat(result, is(expected));
}
}
