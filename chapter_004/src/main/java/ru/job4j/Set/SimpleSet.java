package ru.job4j.Set;

import java.util.Iterator;

public class SimpleSet<E> implements SimpleContainer<E> {
    private Object[] object;
    private int position = 0;
    private int index = 0;

    public SimpleSet(int size) {
        this.object = new Object[size];
    }

    @Override
    public void add(E e) {
        if (position < object.length) {
            if (!check(e)) {
                this.object[position++] = e;
            }
        }
    }

    @Override
    public boolean check(E e) {
        for (int index = 0; index < position; index++) {
            return this.object[index].equals(e) ? true : false;
        }
        return false;
    }


    @Override
    public Iterator<E> iterator() {
        Object[] array = this.object;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (index < array.length) {
                    return array[index] != null ? true : false;
                }
                return false;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    return (E) array[index++];
                }
                return null;
            }
        };
    }
}
