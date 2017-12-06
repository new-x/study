package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {
    private final int[] array;
    private int index = 0;

    public EvenIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        for (int indexCheck = index; indexCheck < array.length; indexCheck++) {
            if (array[indexCheck] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (array.length > index) {
            for (; index < array.length; index++) {
                if (array[index] % 2 == 0) {
                    return array[index++];
                }
            }
        } else {
            throw new NoSuchElementException("Not found element.");
        }
        return null;
    }
}
