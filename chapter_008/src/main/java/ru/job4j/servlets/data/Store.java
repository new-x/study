package ru.job4j.servlets.data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public interface Store {
    public void add(String name, String login, String email);

    public void update(int id, String name, String login, String email);

    public void delete(int id);

    public ConcurrentHashMap<Integer, User> findAll();

    public boolean findById(int id);

    public User getUser(int id);
}
