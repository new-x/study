package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.models.Item;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StubInputTest.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class StubInputTest {
    /**
     * Тестируем класс StubInputTest - тестируем add Item.
     */
    /*@Test
    public void testAdd() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "One", "Desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод menu()
        assertThat(tracker.getAll()[0].getName(), is("One")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    } */
    /** Тестируем класс StubInputTest - тестируем добавление Item и Update Item. */
    /*@Test
    public void testAddEdit() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("One", "Desc", 2017));
        Input input = new StubInput(new String[]{"2", item.getId(), "ReOne", "ReDesc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("ReOne"));
    }
    /** Тестируем класс StubInputTest - тестируем добавление Item и Delete Item. */
    /*@Test
    public void testAddDelete() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("One", "Desc", 2017));
        Input input = new StubInput(new String[] {"0", "Two", "TwoDesc", "3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("Two"));
    }
    /** Тестируем класс StubInputTest - тестируем добавление Item  */
}
