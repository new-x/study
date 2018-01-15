package ru.job4j.List;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    @Test
    public void whenAddItemIsCompete() {
        Container<String> container = new Container<String>();
        container.add("Маша");
        container.add("Даша");
        container.add("Саша");
        container.add("Паша");
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Маша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Даша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Саша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Паша"));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenModCountException(){
        Container<String> container = new Container<String>();
        container.add("Маша");
        Iterator it = container.iterator();
        it.next();
        container.add("Макс");
        assertThat(it.next(), is("Макс"));
    }
}
