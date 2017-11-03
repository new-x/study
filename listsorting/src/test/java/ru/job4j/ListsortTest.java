package ru.job4j;


import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListsortTest {
    @Test
    public void sortList() {
        Listsort sortlist = new Listsort();
        Set<List<Listdata>> listSortSet = new HashSet<>();
        List<Listdata> listSort = new ArrayList<>();
        listSort.add(new Listdata("1", "2", "3"))
        listSort.addAll(
                Arrays.asList(
                        new Listdata("1", "2", "3"),
                        new Listdata("2", "2", "3"),
                        new Listdata("3", "2", "3")
        ));
        listSortSet.add(listSort);
        Set<List<Listdata>> result = sortlist.listSorting(listSortSet);
        assertThat(result, is(-1));
    }

}
