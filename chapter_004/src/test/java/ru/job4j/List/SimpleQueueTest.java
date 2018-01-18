package ru.job4j.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    @Test
    public void whenQueueRemoveFirst(){
        SimpleQueue<String> sq = new SimpleQueue<>();
        sq.push("Один");
        sq.push("Два");
        sq.push("Три");
        String result = String.format("%s:%s:%s", sq.poll(), sq.poll(), sq.poll());
        String expected = "Один:Два:Три";
        assertThat(result, is(expected));
    }

}
