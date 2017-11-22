package ru.job4j;

import java.util.*;

public class Listsort {
/*
    public Set<List<String>> addListToSet(Set<List<String>> data) {
        Set<List<String>> newData = new TreeSet<>(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> left, List<String> right) {
                for(int index = 0; index < data.size(); index++){
                    return left.get(index).compareTo(right.get(index + 1));
                }
                return -1;
            }
        });
        newData.add(data.);
        //newData.add(Arrays.asList("1", "2", "3"));
        //newData.add(Arrays.asList("3", "2", "3"));
        return newData;

    } */

    public static void main(String[] args) {
        Set<List<String>> data = new TreeSet<>(
                new Comparator<List<String>>() {
                    @Override
                    public int compare(List<String> left, List<String> right) {
                        int min = left.size() > right.size() ? right.size() : left.size();
                        for (int index = 0; index != min; index++) {
                            int cmp = left.get(index).compareTo(right.get(index));

                            if (cmp != 0) {
                                return cmp;
                            }
                            //return left.get(0).compareTo(right.get(1));
                            //return right.get(1).compareTo(left.get(0));
                        }
                        if (left.size() > right.size()){
                            return 0;
                        }
                        return 1;
                    }
                }
        );
        data.add(Arrays.asList("3", "2", "1"));
        data.add(Arrays.asList("2", "2", "1"));
        //data.add(Arrays.asList("2", "2", "2"));
        data.add(Arrays.asList("1", "2", "3"));
        System.out.println(data);
    }
}
