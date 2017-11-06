package ru.job4j;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListsortTest {
    @Test
    public void sortList() {
        Set<List<String>> data = new TreeSet<>();
        data.add(Arrays.asList( ("1 2 3")));
        data.add(Arrays.asList( ("2 2 3")));
        data.add(Arrays.asList( ("3 2 3")));
        Listsort sortlist = new Listsort();

        Set<List<String>> result = sortlist.sortList(data);
        assertThat(result, is(-1));
    }

}
