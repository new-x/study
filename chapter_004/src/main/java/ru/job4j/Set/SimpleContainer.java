package ru.job4j.Set;

public interface SimpleContainer<E> extends Iterable<E> {
    void add(E e);
    boolean check(E e);
}
