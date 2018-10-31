package ru.job4j.storage;

import ru.job4j.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStorage implements Storage {
    private List storage;

    public MemoryStorage() {
        this.storage = new CopyOnWriteArrayList();
    }

    @Override
    public void add(User user) {
        this.storage.add(user);
    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public User get(int index) {
        return (User) this.storage.get(index);
    }
}
