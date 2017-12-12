package ru.job4j.Generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {
    @Test
    public void whenAddNameToArray() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.add("Петя");
        simpleArray.add("Маша");
        simpleArray.add("Даша");
        assertThat(simpleArray.get(2), is("Даша") );
    }

    @Test
    public void whenUpdateNameFromArray(){
        SimpleArray<String> simpleArray = new SimpleArray<String>(4);
        simpleArray.add("Петя");
        simpleArray.add("Маша");
        simpleArray.add("Даша");
        simpleArray.update(1, "Таня");
        assertThat(simpleArray.get(1), is("Таня") );
    }
    @Test
    public void whenDeleteNameFromArray() {
        SimpleArray<String> simpleArray = new SimpleArray<String>(5);
        simpleArray.add("Петя");
        simpleArray.add("Маша");
        simpleArray.add("Даша");
        simpleArray.add("Моня");
        simpleArray.delete(0);
        assertThat(simpleArray.get(0), is("Маша") );
    }
}
