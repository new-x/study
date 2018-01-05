package ru.job4j.Set;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class SimpleSetListTest {

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenAddAllElementsComplete() {
        List<String> elements = new LinkedList<String>();
        SimpleSetList ssl = new SimpleSetList(elements);
        ssl.add("Маша");
        ssl.add("Настя");
        ssl.add("Даша");
        assertThat(ssl.iterator().hasNext(), is(true));
        assertThat(ssl.iterator().next(), is("Маша"));
        assertThat(ssl.iterator().hasNext(), is(true));
        assertThat(ssl.iterator().next(), is("Настя"));
        assertThat(ssl.iterator().hasNext(), is(true));
        assertThat(ssl.iterator().next(), is("Даша"));
        assertThat(ssl.iterator().hasNext(), is(false));
    }
}
