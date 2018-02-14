package ru.job4j.Set;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class SimpleSetListTest {

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenAddAllElementsComplete() {
        SimpleSetList<String> ssl = new SimpleSetList<>();
        ssl.add("Антон");
        ssl.add("Марина");
        ssl.add("Антон");
        ssl.add("Денис");
        Iterator it = ssl.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Антон"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Марина"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Денис"));
        it.next();
    }
}
