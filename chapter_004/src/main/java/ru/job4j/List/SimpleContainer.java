package ru.job4j.List;

public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    E remove(int index);
    E get(int index);
    boolean hasDuplicate(E e);
}
