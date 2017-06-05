package ru.job4j.tracker.start;

import ru.job4j.tracker.models.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class Tracker.
 * @author alekseev
 * @since 1.0
 */
public class TrackerTest {
/**
 * Тестируем класс трекер - первый тест.
  */
@Test
public void testMethodGetAll() {
    Tracker tracker = new Tracker();
    Item item = new Item("test1","testDescription",123L);
    tracker.add(item);
    assertThat(tracker.getAll()[0], is(item));
}
}
