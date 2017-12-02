package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MatrixIterator implements Iterator {
    private int[][] array;
    private int indexOne = 0;
    private int indexTwo = 0;

    public MatrixIterator(int[][] array) {
        this.array = array;

    }

    @Override
    public boolean hasNext() {
        if (array.length > indexOne) {
            if (array[indexOne].length > indexTwo) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (indexOne < array.length) {
            if (array[indexOne].length > indexTwo) {
                indexTwo++;
                if (array[indexOne].length == indexTwo) {
                    int index = indexTwo - 1;
                    indexTwo = 0;
                    return array[indexOne++][index];
                }
                return array[indexOne][indexTwo - 1];
            }

        } else {
            throw new NoSuchElementException("No such element.");
        }
        return 0;
        //return array[indexOne][indexTwo++];
    }
}
