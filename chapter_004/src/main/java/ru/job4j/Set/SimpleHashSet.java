package ru.job4j.Set;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleHashSet<E> {
    private Object[] objects = new Object[10];
    private int amount = 0;

    public void add(E e) {
        if (!contains(e)) {
            if (getKey(e) > this.objects.length) {
                this.objects = Arrays.copyOf(this.objects, 10);
            }
            this.objects[getKey(e)] = e;
        }
    }

    public boolean contains(E e) {
        if (amount == 0) {
            return true;
        }
        if (objects[getKey(e)].equals(e)) {
            return true;
        }

        return false;
    }

    public int getKey(E e) {
        return e.hashCode() % this.objects.length;
    }

    public boolean remove(E e) {
        if (contains(e)) {
            System.arraycopy(this.objects, getKey(e) + 1, this.objects, getKey(e), this.objects.length - 1 - getKey(e));
            return true;
        }
        return false;
    }
}
