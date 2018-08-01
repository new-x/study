package ru.job4j.servlets.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 23.07.2018 17:15
 */

public class MemoryStore implements Store {
    private static final Logger Log = LoggerFactory.getLogger(MemoryStore.class);

    private static final MemoryStore INSTANCE = new MemoryStore();

    private List<User> store = new ArrayList<>();

    private final AtomicInteger counter = new AtomicInteger();

    public static MemoryStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        Integer id = counter.incrementAndGet();
        this.store.add(user);
    }

    @Override
    public void update(User user) {
        //this.store.replace (user.getId(), user);
    }

    @Override
    public void delete(int id) {
        this.store.remove(id);
    }

    @Override
    public List<User> findAll() {
        return this.store;
    }

    @Override
    public User findById(int id) {
       // if (this.store.containsKey(id)) {
        //}
        return null;
    }

}
