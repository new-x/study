package ru.job4j.checkspeed;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by aleks on 03.09.2017.
 */
public class CheckoneTest {
    @Test
    public void testCheckoneTestAddLinkedList() {
        Checkone testone = new Checkone();
        Collection<String> collection = new LinkedList<>();
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
    @Test
    public void testCheckoneTestDeleteLinkedList() {
        Checkone testone = new Checkone();
        Collection<String> collection = new LinkedList<>();
        for (int index = 0; index < 10000; index++){
            collection.add(String.valueOf(Math.random() * 10000));
        }
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
    @Test
    public void testCheckoneTestAddArrayList() {
        Checkone testone = new Checkone();
        Collection<String> collection = new ArrayList<>();
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
    @Test
    public void testCheckoneTestDeleteArrayList() {
        Checkone testone = new Checkone();
        Collection<String> collection = new ArrayList<>();
        for (int index = 0; index < 10000; index++){
            collection.add(String.valueOf(Math.random() * 10000));
        }
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
    @Test
    public void testCheckoneTestAddTreeSet() {
        Checkone testone = new Checkone();
        Collection<String> collection = new TreeSet<>();
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
    @Test
    public void testCheckoneTestDeleteTreeSet() {
        Checkone testone = new Checkone();
        Collection<String> collection = new TreeSet<>();
        for (int index = 0; index < 10000; index++){
            collection.add(String.valueOf(Math.random() * 10000));
        }
        long result = testone.add(collection, 10000);
        assertThat(result, is(-1));
    }
}
