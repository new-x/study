package ru.job4j.List;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Container<E> implements SimpleContainer<E> {
    private int modCount = 0;
    private Object[] objects = new Object[1];
    private int position = 0;

    @Override
    public void add(E e) {
        if (position < this.objects.length) {
            if (this.objects.length > position) {
                this.objects[position++] = e;
                modCount++;
            } else {
                this.objects = Arrays.copyOf(this.objects, position + 3);
                this.objects[position++] = e;
                modCount++;
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
            int index = 0;
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
