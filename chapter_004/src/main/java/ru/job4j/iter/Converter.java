package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> active = it.hasNext() ? it.next() : null;

            @Override
            public boolean hasNext() {
                while (this.active != null) {
                    if (this.active.hasNext()) {
                        return true;
                    } else {
                        this.active = it.hasNext() ? it.next() : null;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    return this.active.next();
                } else {
                    throw new NoSuchElementException("Not found element");
                }
            }
        };
    }
}
