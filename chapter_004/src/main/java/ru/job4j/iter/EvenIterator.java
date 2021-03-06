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
        while (index < this.array.length) {
            if (this.array[index] % 2 == 0) {
                return true;
            } else {
                index++;
            }
        }
        return false;
        /*for (int indexCheck = index; indexCheck < array.length; indexCheck++) {
            if (array[indexCheck] % 2 == 0) {
                index = indexCheck;
                return true;
            }
        }
        return false;
        */
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return this.array[index++];
        } else {
            throw new NoSuchElementException("Not found element.");
        }

/*
        if (array.length > index) {
            for (; array.length > index; index++) {
                if (hasNext()) {
                    return array[index++];
                }
                else {
                    throw new NoSuchElementException("Not found element.");
                }
            }
        }
        return null;
        */
    }
}
