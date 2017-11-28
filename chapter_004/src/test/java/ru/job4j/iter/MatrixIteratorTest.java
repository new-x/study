package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class MatrixIteratorTest {

    private Iterator<Integer> it;

    @Before
    public void setUp(){
        it = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
        //it = new MatrixIterator(new int[] {1, 2, 3, 4, 5, 6});
    }

    @Test
    public void test() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
    }

    @Test
    public void hasNextNextSequentialInvocation () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
        //it.next();
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        //it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        //it.next();
    }
}
