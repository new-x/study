package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;
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
     * Тестируем класс трекер - тестируем метод getAll.
     */
    @Test
    public void testMethodGetAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Тестируем класс трекер - тестируем метод add.
     */
    @Test
    public void testMethodAdd() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        Item result = tracker.add(item);
        assertThat(result, is(item));
    }

    /**
     * Тестируем класс трекер - тестируем метод findById.
     */
    @Test
    public void testMethodFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1","testDescription",123L);
        item.setId("first");
        Item result = tracker.findById("first");
        assertThat(result, is("First"));
    }

}
