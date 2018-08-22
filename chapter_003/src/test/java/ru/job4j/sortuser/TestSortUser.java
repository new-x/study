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
                        new User("Маринэ", 10),
                        new User ("Максим", 8),
                        new User("Максимка", 8),
                        new User("Даша", 4)
                )
        );

        Set<User> users = sortUser.sort(list);
    }

    @Test
    public void testSortUserByLenghtName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Маринэ", 10),
                        new User ("Максим", 8),
                        new User("Максимка", 8),
                        new User("Даша", 4)
                )
        );
        List<User> users = sortUser.sortNameLength(list);
    }

    @Test
    public void testSortUserByNameAndAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.addAll(
                Arrays.asList(
                        new User("Иван", 20),
                        new User ("Максим", 15),
                        new User("Иван", 21),
                        new User("Максим", 19)
                )
        );
        List<User> users = sortUser.sortByAllFields(list);
    }

}
