package ru.job4j.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleHashSetTest {
    @Test
    public void whenAddTrue() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>();
        shs.add("Маша");
        shs.add("Даша");
        shs.add("Паша");
        shs.add("Настя");
        shs.add("Кирилл");
        assertThat(shs.contains("Маша"), is(true));
        assertThat(shs.contains("Даша"), is(true));
        assertThat(shs.contains("Паша"), is(true));
        assertThat(shs.contains("Настя"), is(true));
    }

    @Test
    public void whenRemoveTrue() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>();
        shs.add("Маша");
        shs.add("Даша");
        shs.add("Паша");
        shs.add("Настя");
        shs.add("Кирилл");
        shs.remove("Паша");
        assertThat(shs.contains("Паша"), is(true));
    }

}
