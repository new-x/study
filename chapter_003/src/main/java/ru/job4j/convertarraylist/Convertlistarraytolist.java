package ru.job4j.convertarraylist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleks on 15.09.2017.
 */
public class Convertlistarraytolist {
    public List<Integer> convert(List<int[]> list) {
        List <Integer> lists = new LinkedList<>();
        for (int[] value : list) {
            for (int element : value) {
                lists.add(element);
            }
        }

        return lists;
    }

}
