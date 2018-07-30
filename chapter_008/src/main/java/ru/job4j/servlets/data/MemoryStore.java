package ru.job4j.servlets.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public class MemoryStore<K> implements Store {
    private static final Logger Log = LoggerFactory.getLogger(MemoryStore.class);

    private static final MemoryStore INSTANCE = new MemoryStore();

    private ConcurrentHashMap<Integer, User> store = new ConcurrentHashMap<>();

    private final AtomicInteger counter = new AtomicInteger();

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(String name, String login, String email) {
        Integer id = counter.incrementAndGet();
        this.store.putIfAbsent(new Integer(id), new User(id, name, login, email, new GregorianCalendar()));
    }

    @Override
    public void update(int id, String name, String login, String email) {
        User user = this.store.get(id);
        user.setName(name);
        user.setLogin(login);
        user.setEmail(email);
        this.store.replace (new Integer(id), user);
    }

    @Override
    public void delete(int id) {
        this.store.remove(id);
    }

    @Override
    public ConcurrentHashMap<Integer, User> findAll() {
        return this.store;
    }

    @Override
    public boolean findById(int id) {
        if (this.store.containsKey(id)) {
           return true;
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        return this.store.get(id);
    }
}
