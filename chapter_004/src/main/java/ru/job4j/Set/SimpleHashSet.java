package ru.job4j.Set;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleHashSet<E> implements SimpleHashContainer<E> {
    private Object[] objects;
    private int key = 0;
    private int index = 0;

    public SimpleHashSet(int size) {
        this.objects = new Object[size];
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            if (this.objects.length > this.key) {
                this.objects[this.key++] = e;
            } else {
                this.objects = Arrays.copyOf(this.objects, this.key + 3);
                this.objects[key++] = e;
            }
        }
    }

    @Override
    public boolean contains(E e) {
        for (Object object : this.objects) {
            if (object != null) {
                if (object.equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(E e) {
        if (contains(e)) {
            int index = 0;
            for (; index < this.key; index++) {
                if (this.objects[index].equals(e)) {
                    break;
                }
            }
            System.arraycopy(this.objects, index + 1, this.objects, index, --this.key - index);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Object[] array = this.objects;
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
