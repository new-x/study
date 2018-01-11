package ru.job4j.List;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Container<E> implements SimpleContainer<E> {
    private int modCount;
    private Object[] objects;
    private int position = 0;
    private int index = 0;

    public Container(int size, int modCount) {
        this.objects = new Object[size];
        this.modCount = modCount;
    }

    @Override
    public void add(E e) {
        if (modCount > 0) {
            if (this.objects.length > position) {
                this.objects[position++] = e;
            } else {
                this.objects = Arrays.copyOf(this.objects, position + 3);
                if (--modCount > 0) {
                    this.objects[position++] = e;
                } else {
                    throw new ConcurrentModificationException("Mod count exception.");
                }
            }
        }
    }

    @Override
    public E get(int index) {
        if (index < position) {
            return (E) this.objects[index];
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        Object[] array = this.objects;
        int state = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                if (array[index] != null) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                if (modCount != 0) {
                    if (hasNext()) {
                        return (E) array[index++];
                    }
                } else {
                    throw new ConcurrentModificationException("Mod count exception.");
                }
                return null;
            }
        };
    }
}
