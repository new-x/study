package ru.job4j.servlets.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public class MemoryStore<K> implements Store<K,User> {
    private static final Logger Log = LoggerFactory.getLogger(MemoryStore.class);
    private static final MemoryStore INSTANCE = new MemoryStore();
    private ConcurrentHashMap<K, User> store = new ConcurrentHashMap<>();

    public static synchronized MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(int id, String name, String login, String email) {
        this.store.putIfAbsent((K) new Integer(id), new User(id, name, login, email, new GregorianCalendar()));
    }

    @Override
    public void update(int id, String name, String login, String email) {
        User user = this.store.get(id);
        user.setName(name);
        user.setLogin(login);
        user.setEmail(email);
        this.store.replace((K) new Integer(id), user);
    }

    @Override
    public void delete(int id) {
        this.store.remove(id);
    }

    @Override
    public ConcurrentHashMap<K, User> findAll() {
        return this.store;
    }

    @Override
    public boolean findById(int id) {
        if (this.store.containsKey(id)) {
           return true;
        }
        return false;
    }

}
