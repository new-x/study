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
        Thread threadOne =  new StartThreads(list,"Один");
        Thread threadTwo =  new StartThreads(list,"Два");
        Thread threadThree =  new StartThreads(list,"Три");
        Thread threadFour =  new StartThreads(list,"Четыре");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(list.get(0), is("Один"));
        assertThat(list.get(1), is("Два"));
        assertThat(list.get(2), is("Три"));
        assertThat(list.get(3), is("Четыре"));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIterableIsError(){
        NodeList<String> list = new NodeList();
        Thread threadOne =  new StartThreads(list,"Один");
        Thread threadTwo =  new StartThreads(list,"Два");
        Thread threadThree =  new StartThreads(list,"Три");
        Thread threadFour =  new StartThreads(list,"Четыре");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        threadFour.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Один"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Два"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Три"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Четыре"));
        Thread threadFive = new StartThreads(list, "Пять");
        threadFive.start();
        try {
            threadFive.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Один"));
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

    private class StartThreads extends Thread {
        NodeList<String> list;
        String name;

        public StartThreads(NodeList<String> list, String name) {
            this.list = list;
            this.name = name;
        }

        @Override
        public void run() {
            list.add(this.name);
        }

    }

}
