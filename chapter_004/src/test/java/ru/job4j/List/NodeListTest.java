package ru.job4j.List;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NodeListTest {

    @Test
    public void whenAddNodeTrue() {
        NodeList<String> list = new NodeList();
        list.add("Один");
        list.add("Два");
        assertThat(list.get(0), is("Один"));
        assertThat(list.get(1), is("Два"));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterableIsError(){
        NodeList<String> list = new NodeList();
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Один"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Два"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Три"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Четыре"));
        list.add("Пять");
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenRemoveComplete(){
        NodeList<String> list = new NodeList();
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        list.remove(3);
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Один"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Два"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Три"));
    }
    @Test
    public void whenIsDublicate() {
        NodeList<String> list = new NodeList();
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        list.add("Один");
        assertThat(list.hasDuplicate("Один"), is(true));
    }

}
