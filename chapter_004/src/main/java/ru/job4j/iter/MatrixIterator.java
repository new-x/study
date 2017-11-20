package ru.job4j.iter;

import java.util.Iterator;


public class MatrixIterator implements Iterator {
    private int[][] array;
    private int index = 0;

    public MatrixIterator(int[][] array){
        this.array = array;

    }

    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public Object next() {
        for(int arr[] : array){
            for(int arrtwo : arr){
                if(arrtwo != 0){
                    return index++;
                }
            }
        }
      return 0;
    }
}
