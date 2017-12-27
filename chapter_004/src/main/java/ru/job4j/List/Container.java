package ru.job4j.List;

import java.util.Arrays;
import java.util.Iterator;

public class Container<E> implements SimpleContainer<E> {
    private int modCount = 0;
    private Object[] objects;
    private int position = 0;

    public Container(int size) {
        this.objects = new Object[size];
    }

    @Override
    public void add(E e) {
        if (this.objects.length > position){
            this.objects[position++] = e;
        } else {
            this.objects = Arrays.copyOf(this.objects, position + 3);
            this.objects[position++] = e;
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
        Iterator<E> it = new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                return null;
            }
        };
        return null;
    }
}
