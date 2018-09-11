package ru.job4j;

import org.junit.Test;
import ru.job4j.models.Item;
import ru.job4j.work.Work;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class WorkTest {
    private Work work = new Work();
    private Calendar calendar = Calendar.getInstance();
    @Test
    public void tesAddItem() {
        Item item = new Item(0, "NoteOne", false, new Timestamp(calendar.getTimeInMillis()));
        work.addItem(item);
        item = work.getItem(item);
        assertTrue(work.getItem(item).getDescription().equals(item.getDescription()));
        work.deleteItem(item);
    }

    @Test
    public void updateItem() {
        Item item = new Item(0, "NoteTwo", false, new Timestamp(calendar.getTimeInMillis()));
        work.addItem(item);
        item = work.getItem(item);
        item.setDone(true);
        work.updateItem(item);
        assertTrue(work.getItem(item).isDone() == item.isDone());
    }

    @Test
    public void getAllItems() {
        List<Item> allItems = work.getAllItems();
        for (Item item : allItems) {
            System.out.println(item);
        }
    }
}
