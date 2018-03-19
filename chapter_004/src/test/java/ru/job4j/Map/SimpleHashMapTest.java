package ru.job4j.Map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class SimpleHashMapTest {
    @Test(expected = NullPointerException.class)
    public void whenPutChangeDelete() {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap();
        simpleHashMap.put(null, "Ono");
        simpleHashMap.put("One", "Elena");
        simpleHashMap.put("Two", "Max");
        simpleHashMap.put("Three", "Kirill");
        simpleHashMap.put("Four", null);
        simpleHashMap.changeArraySize();
        simpleHashMap.delete("Two");
        Iterator it = simpleHashMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Ono"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Elena"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Max"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Kirill"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(java.util.Optional.of(null)));
        it.next();
    }
}
