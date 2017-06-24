package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Class TrackerTest.
 *
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
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    /**
     * Тестируем класс трекер - тестируем метод add.
     */
    @Test
    public void testMethodAdd() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(item.getId(), is(notNullValue()));
    }

    /**
     * Тестируем класс трекер - тестируем метод findById.
     */
    @Test
    public void testMethodFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }

    /**
     * Тестируем класс трекер - тестируем метод update.
     */
    @Test
    public void testMethodUpdate() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("test1", "testDescription", 123L);
        tracker.add(itemFirst);
        Item itemTwo = new Item("test2", "testDesc2", 123L);
        itemTwo.setId(itemFirst.getId());
        tracker.update(itemTwo);
        assertThat(tracker.findById(itemTwo.getId()), is(itemTwo));
    }

    /**
     * Тестируем класс трекер - тестируем метод update.
     */
    @Test
    public void testMethodDelete() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription1", 121);
        Item itemTwo = new Item("test2", "testDescription2", 122);
        Item itemThree = new Item("test3", "testDescription3", 123);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.delete(itemOne);
        assertThat(itemTwo, is(tracker.getAll()[0]));
    }

    /**
     * Тестируем класс трекер - тестируем метод FindAll.
     */
    @Test
    public void testMethodFindByName() {
        Tracker tracker = new Tracker();
        Item itemOne = new Item("test1", "testDescription1", 121);
        Item itemTwo = new Item("test2", "testDescription2", 122);
        Item itemThree = new Item("test3", "testDescription3", 123);
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        assertThat(tracker.findByName("test3")[0], is(itemThree));
    }
}
