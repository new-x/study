package ru.job4j.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    @Test
    public void whenStackRemoveLast(){
    SimpleStack<String> ss = new SimpleStack<>();
        ss.push("Один");
        ss.push("Два");
        ss.push("Три");
        String result = String.format("%s:%s:%s", ss.poll(), ss.poll(), ss.poll());
        String expected = "Три:Два:Один";
        assertThat(result, is(expected));
    }

}
