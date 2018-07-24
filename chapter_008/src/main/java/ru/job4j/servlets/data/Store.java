package ru.job4j.servlets.data;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public interface Store<K, V> {
    public void add(int id, String name, String login, String email);

    public void update(int id, String name, String login, String email);

    public void delete(int id);

    public ConcurrentHashMap<K, V> findAll();

    public boolean findById(int id);
}
