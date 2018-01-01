package ru.job4j.Set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class SimpleSetTest {
    @Test
    public void whenAddNoRepetition(){
        SimpleSet<String> ss = new SimpleSet<String>(3);
        ss.add("Маша");
        ss.add("Даша");
        ss.add("Паша");
        assertThat(ss.iterator().hasNext(), is(true));
        assertThat(ss.iterator().next(), is("Маша"));
        assertThat(ss.iterator().hasNext(), is(true));
        assertThat(ss.iterator().next(), is("Даша"));
        assertThat(ss.iterator().hasNext(), is(true));
        assertThat(ss.iterator().next(), is("Паша"));
        assertThat(ss.iterator().hasNext(), is(false));
    }
}