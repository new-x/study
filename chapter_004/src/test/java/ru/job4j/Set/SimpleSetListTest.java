package ru.job4j.Set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class SimpleSetListTest {

    @Test (expected = NoSuchElementException.class)
    public void whenAddAllElementsComplete() {
        SimpleSetList<String> ssl = new SimpleSetList<>();
        ssl.add("Антон");
        ssl.add("Марина");
        ssl.add("Антон");
        ssl.add("Денис");
        Iterator it = ssl.elements.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Антон"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Марина"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Денис"));
        it.next();
    }
}
