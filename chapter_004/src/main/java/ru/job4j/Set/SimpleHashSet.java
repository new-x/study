package ru.job4j.Set;

import java.util.Arrays;

public class SimpleHashSet<E> {
    private Object[] objects = new Object[10];
    private int amount = 0;

    public void add(E e) {
        if (!contains(e)) {
            if (amount == objects.length) {
                changeArraySize();
            }
            this.objects[getKey(e)] = e;
            amount++;
        }
    }

    public boolean contains(E e) {
        if (amount == 0) {
            return false;
        }
        if (objects[getKey(e)] == null) {
            return false;
        }
        if (objects[getKey(e)].equals(e)) {
            return true;
        }

        return false;
    }

    public void changeArraySize() {
        Object[] newObjects = new Object[this.objects.length + 10];
        for (Object object : this.objects) {
            if (object != null) {
                int newKey = object.hashCode() % newObjects.length;
                if (newKey < 0) {
                    newKey *= -1;
                }
                newObjects[newKey] = object;
            }
        }
        this.objects = newObjects;
    }

    public int getArraySize() {
        return objects.length;
    }

    public int getKey(E e) {
        int key = e.hashCode() % this.objects.length;
        if (key < 0) {
           key = key * -1;
        }
        return key;
    }

    public void remove(E e) {
        if (contains(e)) {
            this.objects[getKey(e)] = null;
        }
    }
}
