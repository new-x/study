package ru.job4j.Map;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Object[] objects = new Object[16];
    private int countElements = 0;


    public void put(K key, V value) {
        if (countElements < objects.length * 0.75) {
            if (key == null) {
                this.objects[0] = new Entry(key, value);
            }
            if (key != null) {
                if (this.objects[getIndex(key)] != null) {
                    countElements--;
                }
                this.objects[getIndex(key)] = new Entry(key, value);
            }
        } else {
            changeArraySize();
            this.objects[getIndex(key)] = new Entry(key, value);
        }
        countElements++;
    }

    public V get(K key) {
        if (key != null) {
            Entry entry = (Entry) this.objects[getIndex(key)];
            return (V) entry.value;
        } else {
            Entry entry = (Entry) this.objects[0];
            return (V) entry.value;
        }
    }

    public void delete(K key) {
        if (key != null) {
            this.objects[getIndex(key)] = null;
        } else {
            this.objects[0] = null;
        }
        countElements--;
    }

    public void changeArraySize() {
        Object[] newObjects = new Object[this.objects.length + 16];
        for (Object object : this.objects) {
            if (object != null) {
                Entry entry = (Entry) object;
                int newKey = entry.hash % (newObjects.length);
                if (newKey < 0) {
                    newKey *= -1;
                }
                newObjects[newKey] = object;
            }
        }
        this.objects = newObjects;
    }

    private int getIndex(K key) {
        int arrayIndex = key.hashCode() % (this.objects.length);
        if (arrayIndex < 0) {
            arrayIndex = arrayIndex * -1;
        }
        return arrayIndex;
    }

    @Override
    public Iterator<V> iterator() {
        Object[] objects = this.objects;
        return new Iterator<V>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                for (; index < objects.length; index++) {
                    Entry entry = (Entry) objects[index];
                        if (entry.value != null) {
                            return true;
                        }
                }
                return false;
            }

            @Override
            public V next() {
                if (hasNext()) {
                    Entry entry = (Entry) objects[index++];
                    return (V) entry.value;
                } else {
                    throw new NullPointerException();
                }
            }
        };
    }
}
