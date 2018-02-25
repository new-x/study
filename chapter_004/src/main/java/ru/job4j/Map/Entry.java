package ru.job4j.Map;

public class Entry<K, V> {
    protected K key;
    protected V value;
    protected int hash = 0;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        if (key != null) {
            this.hash = key.hashCode();
        } else {
            this.key = null;
        }

    }

}
