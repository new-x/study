package ru.job4j.convert;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleks on 07.09.2017.
 */
public class Converter {
    public List<Integer> toList (int[][] array) {
        List<Integer> list = new LinkedList<>();
        for (int index[] : array){
            for (int arr : index){
            list.add(arr);
            }
        }
        return list;
    }
    public int[][] toArray (List<Integer> list, int rows) {
        int size = list.size();
        int index = 0;
        int[][] array = new int[rows][size/rows + size%rows];
        for (int indexRows = 0; indexRows < rows; indexRows++){
            for (int indexLine = 0; indexLine < size/rows + size%rows; indexLine++){
                if (index < size) {
                    if(list.get(index) != null){
                        array[indexRows][indexLine] = list.get(index);
                    } else {
                        array[indexRows][indexLine] = 0;
                    }
                }else {
                    array[indexRows][indexLine] = 0;
                }
                index++;
            }
        }

    return array;
    }
}
