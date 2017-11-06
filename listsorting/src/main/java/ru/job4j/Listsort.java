package ru.job4j;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Listsort {
    public Set<List<String>> sortList(Set<List<String>> data) {
        data = new TreeSet<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> left, List<String> right) {
                return left.get(0).compareTo(right.get(1));
            }
        });
        return data;
    }


}
