package ru.job4j.List;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ContainerTest {

    @Test
    public void whenAddItemIsCompete() {
        Container<String> container = new Container<String>(3);
        container.add("Маша");
        container.add("Даша");
        container.add("Саша");
        container.add("Паша");
        assertThat(container.get(3), is("Паша"));
    }

}
