package ru.job4j.List;

public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    E get(int index);
}
