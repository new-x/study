package ru.job4j.Set;

public interface SimpleHashContainer<E> extends Iterable<E> {
    void add(E e);
    boolean contains(E e);
    boolean remove(E e);
}
