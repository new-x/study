package ru.job4j.Generic;

public class SimpleArray<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T name) {
        if (index + 1 < objects.length) {
            this.objects[index++] = name;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int position) {
        if (position < this.objects.length & position >= 0) {
            return (T) this.objects[position];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    public void update(int position, T newName) {
        if (position < this.objects.length & position >= 0) {
            this.objects[position] = newName;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void delete(int position) {
        if (position < this.objects.length & position >= 0) {
            System.arraycopy(this.objects, position + 1, this.objects, position, index - (position + 1));
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

}
