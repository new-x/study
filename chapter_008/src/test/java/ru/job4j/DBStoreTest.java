package ru.job4j;

import org.junit.Test;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.User;

import java.util.Calendar;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 01.08.2018 20:56
 */

public class DBStoreTest {
    DBStore dbStore = DBStore.getInstance();

    @Test
    public void testDBStore() {
        Calendar calendar = Calendar.getInstance();
        User user = new User("Kirill", "limer2012", "mail@mail.ru", calendar);
            dbStore.add(user);
    }
}
