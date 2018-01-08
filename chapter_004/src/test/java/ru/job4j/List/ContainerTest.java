package ru.job4j.List;

import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    @Test
    public void whenAddItemIsCompete() {
        Container<String> container = new Container<String>(3, 2);
        container.add("Маша");
        container.add("Даша");
        container.add("Саша");
        container.add("Паша");
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is("Маша"));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is("Даша"));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is("Саша"));
        assertThat(container.iterator().hasNext(), is(true));
        assertThat(container.iterator().next(), is("Паша"));
        assertThat(container.iterator().hasNext(), is(false));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenModCountException(){
        Container<String> container = new Container<String>(3, 1);
        container.add("Маша");
        container.add("Даша");
        container.add("Саша");
        container.add("Паша");
    }
}
