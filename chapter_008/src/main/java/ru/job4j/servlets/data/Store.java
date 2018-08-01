package ru.job4j.servlets.data;

import java.util.List;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public interface Store {
    public void add(User user);

    public void update(User user);

    public void delete(int id);

    public List<User> findAll();

    public User findById(int id);
}
