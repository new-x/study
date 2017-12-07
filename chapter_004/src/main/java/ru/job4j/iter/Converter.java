package ru.job4j.iter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> active = !it.hasNext() ? null : it.next();

            @Override
            public boolean hasNext() {
                while (this.active != null){
                    if (!this.active.hasNext()){
                       this.active = it.hasNext() ? it.next() : null;
                    } else {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                if (!this.hasNext()){
                    throw new NoSuchElementException("Not found element");
                }
                return this.active.next();
            }
        };
    }
}
