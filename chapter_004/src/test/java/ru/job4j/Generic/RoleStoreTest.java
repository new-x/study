package ru.job4j.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class RoleStoreTest {
    @Test
    public void whenAddModelIsThisModel() {
        Store<Role> store = new RoleStore(5);
        store.add(new Role("Крис"));
        store.add(new Role("Наташа"));
        store.add(new Role("Таня"));
        store.add(new Role("Лара"));
        assertThat(store.findById("Наташа"), is(1));
    }

    @Test
    public void whenReplaseModelIsTrue() {
        Store<Role> store = new RoleStore(5);
        store.add(new Role("Крис"));
        store.add(new Role("Наташа"));
        store.add(new Role("Таня"));
        store.add(new Role("Лара"));
        boolean result = store.replace("Наташа", new Role("Максим"));
        assertThat(result, is(true));
    }

    @Test
    public void whenDeleteModelIsTrue() {
        Store<Role> store = new RoleStore(5);
        store.add(new Role("Крис"));
        store.add(new Role("Наташа"));
        store.add(new Role("Таня"));
        store.add(new Role("Лара"));
        boolean result = store.delete("Наташа");
        assertThat(result, is(true));
    }

}
