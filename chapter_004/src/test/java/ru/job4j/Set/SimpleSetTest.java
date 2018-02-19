package ru.job4j.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class SimpleSetTest {
    @Test
    public void whenAddNoRepetition(){
        SimpleSet<String> ss = new SimpleSet<String>();
        ss.add("Маша");
        ss.add("Даша");
        ss.add("Паша");
        Iterator it = ss.container.iterator();
        assertThat(ss.container.hasDuplicate("Даша"), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Маша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Даша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Паша"));
        assertThat(it.hasNext(), is(false));
    }
}