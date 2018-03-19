package ru.job4j.Map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void whenShud() {
        Map map = new HashMap();
        User user1 = (new User("Andre", 1, new GregorianCalendar(2018, 1, 2)));
        User user2 = (new User("Andre", 1, new GregorianCalendar(2018, 1, 2)));
        map.put(user1, "One");
        map.put(user2, "One");
        System.out.println(user1.hashCode() + " " + user2.hashCode());
        System.out.println(user1.equals(user2));
        System.out.println(map);
        assertThat(user1, is(user2));
    }
}
