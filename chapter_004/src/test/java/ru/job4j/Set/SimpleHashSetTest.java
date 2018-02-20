package ru.job4j.Set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleHashSetTest {
    @Test
    public void whenCheckAddElements() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>();
        shs.add("One");
        shs.add("Two");
        shs.add("Three");
        shs.add("Four");
        assertThat(shs.contains("Two"), is(true));
        assertThat(shs.contains("Three"), is(true));
        assertThat(shs.contains("Four"), is(true));
    }

    @Test
    public void whenRemoveAddElements() {
        SimpleHashSet<String> shs = new SimpleHashSet<String>();
        shs.add("One");
        shs.add("Two");
        shs.add("Three");
        shs.add("Four");
        shs.remove("Two");
        assertThat(shs.contains("Two"), is(false));
    }

}
