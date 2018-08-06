package ru.job4j;

import org.junit.Test;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.User;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 01.08.2018 20:56
 */

public class DBStoreTest {
    DBStore dbStore = DBStore.getInstance();

    @Test
    public void getAllUsers() {
        List<User> list = dbStore.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        User user = new User("Kirill Alekseev", "limer2012", "cross", "mail@ mail.ru", new GregorianCalendar());
        dbStore.add(user);
    }

    @Test
    public void getUser() {
        User user = dbStore.findById(1);
        System.out.println(user.getLogin());
    }

    @Test
    public void getRole() {
        List<Role> allRoles = dbStore.getAllRoles();
        for (Role role : allRoles) {
            System.out.println(role);
        }
    }
}
