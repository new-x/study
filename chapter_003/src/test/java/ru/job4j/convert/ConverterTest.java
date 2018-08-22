package ru.job4j.convert;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by aleks on 07.09.2017.
 */
public class ConverterTest {
    @Test
    public void convertArrayToList() {
        int[][] array = {{1, 2, 3, 4, 5, 6},{1, 2, 3, 4, 5, 6}};
        Converter converter = new Converter();
        List <Integer> result = converter.toList(array);
    }
    @Test
    public void convertListToArray() {
        Converter converter = new Converter();
        List <Integer> list = new LinkedList<>();
        for (int index = 0; index < 7; index++){
            list.add(index);
        }
        int[][] result = converter.toArray(list, 3);
    }
}
