package ru.job4j.List;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Container<E> implements SimpleContainer<E> {
    private int modCount = 0;
    private Object[] objects = new Object[2];
    private int position = 0;

    @Override
    public void add(E e) {
        if (this.objects.length - 1 > this.position) {
            this.objects[this.position++] = e;
            modCount++;
        } else {
            this.objects = Arrays.copyOf(this.objects, position + 3);
            this.objects[position++] = e;
            modCount++;
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        if (index < position) {
            return (E) this.objects[index];
        }
        return null;
    }

    @Override
    public boolean hasDuplicate(E e) {
        for (int index = 0; index < this.objects.length; index++) {
            if (this.objects[index] != null) {
                if (this.objects[index].equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Object[] array = this.objects;
        int state = modCount;
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (state == modCount) {
                    return index < position;
                } else {
                    throw new ConcurrentModificationException("Mod count exception.");
                }
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) array[index++];
            }
        };
    }
}
