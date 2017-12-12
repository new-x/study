package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator {
    private final int[] array;
    private int index = 0;

    public PrimeIterator(final int[] array) {
        this.array = array;
    }

    public boolean primeNumber(int num) {
        if (num > 1) {
            for (int i = 2; i <= num / 2; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        while (index < array.length) {
            if (primeNumber(array[index]) == true) {
                return true;
            } else {
                index++;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        if (hasNext()){
            return array[index++];
        }
        else {
            throw new NoSuchElementException("Not found element.");
        }
    }
}
