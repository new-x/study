package ru.job4j.List;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {
    @Test
    public void whenAddItemIsCompete() {
        Container<String> container = new Container();
        Thread threadOne =  new StartThread(container,"Маша");
        Thread threadTwo =  new StartThread(container,"Даша");
        Thread threadThree =  new StartThread(container,"Саша");
        Thread threadFour =  new StartThread(container,"Паша");
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
        Iterator it = container.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Маша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Даша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Саша"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Паша"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenModCountException() {
        Container<String> container = new Container();
        Thread threadOne =  new StartThread(container,"Маша");
        Thread threadTwo =  new StartThread(container,"Даша");
        Thread threadThree =  new StartThread(container,"Саша");
        Thread threadFour =  new StartThread(container,"Паша");
        threadOne.start();
        threadTwo.start();
        threadThree.start();
        Iterator it = container.iterator();
        threadFour.start();
        try {
            threadOne.join();
            threadTwo.join();
            threadThree.join();
            threadFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIsDublicate() {
        Container<String> container = new Container();
        container.add("Маша");
        container.add("Даша");
        container.add("Саша");
        boolean result = container.hasDuplicate("Саша");
        assertThat(result, is(true));
    }

    private class StartThread extends Thread {
        Container<String> container;
        String name;

        public StartThread(Container<String> container, String name) {
            this.container = container;
            this.name = name;
        }

        @Override
        public void run() {
            container.add(this.name);
        }

    }
}
