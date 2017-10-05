package ru.job4j.sortuser;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestSortUser {
    @Test
    public void testSortUserListToTreeSet() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Марина", 10),
                        new User ("Максим", 8),
                        new User("Максим", 8),
                        new User("Даша", 4)
                )
        );

        Set<User> users = sortUser.sort(list);
        assertThat(users, is(-1));
    }

}
