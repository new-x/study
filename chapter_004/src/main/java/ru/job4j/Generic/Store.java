package ru.job4j.Generic;

public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    int findById(String id);
}
