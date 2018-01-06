package ru.job4j.Set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleHashSetTest {
    @Test
    public void whenAddTrue() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>(3);
        shs.add("Маша");
        shs.add("Даша");
        shs.add("Паша");
        shs.add("Настя");
        shs.add("Кирилл");
        assertThat(shs.contains("Паша"), is(true));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Маша"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Даша"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Паша"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Настя"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Кирилл"));
    }

    @Test
    public void whenRemoveTrue() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>(3);
        shs.add("Маша");
        shs.add("Даша");
        shs.add("Паша");
        shs.add("Настя");
        shs.add("Кирилл");
        shs.remove("Паша");
        assertThat(shs.contains("Паша"), is(false));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Маша"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Даша"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Настя"));
        assertThat(shs.iterator().hasNext(), is(true));
        assertThat(shs.iterator().next(), is("Кирилл"));
    }

}
