package ru.job4j.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {
    @Test
    public void whenAddModelIsThisModel() {
        Store<User> store = new UserStore(5);
        store.add(new User("Петя"));
        store.add(new User("Маша"));
        store.add(new User("Даша"));
        store.add(new User("Настя"));
        assertThat(store.findById("Маша"), is(1));
    }

    @Test
    public void whenReplaseModelIsTrue() {
        Store<User> store = new UserStore(5);
        store.add(new User("Петя"));
        store.add(new User("Маша"));
        store.add(new User("Даша"));
        store.add(new User("Настя"));
        boolean result = store.replace("Маша", new User("Кира"));
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteModelIsTrue() {
        Store<User> store = new UserStore(5);
        store.add(new User("Петя"));
        store.add(new User("Маша"));
        store.add(new User("Даша"));
        store.add(new User("Настя"));
        boolean result = store.delete("Маша");
        assertThat(result, is(true));
    }

}
