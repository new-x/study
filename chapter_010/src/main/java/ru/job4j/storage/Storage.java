package ru.job4j.storage;

import ru.job4j.model.User;

public interface Storage<T extends User> {
    void add(T data);
    void delete();
    void update();
    T get(int index);
}
