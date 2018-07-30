package ru.job4j.servlets.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.servlets.data.MemoryStore;
import ru.job4j.servlets.data.Store;
import ru.job4j.servlets.data.User;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.logic
 * Create data: 23.07.2018 17:08
 */

public class ValidateService {
    private static final Logger Log = LoggerFactory.getLogger(ValidateService.class);
    private static final ValidateService INSTANCE = new ValidateService();
    private final Store logic = MemoryStore.getInstance();

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    public void add(String name, String login, String email) {
        logic.add(name, login, email);
    }

    public void update(int id, String name, String login, String email) {
        if (logic.findById(id)) {
            logic.update(id, name, login, email);
        }

    }

    public boolean delete(int id) {
        boolean result = false;
        if (logic.findById(id)) {
            logic.delete(id);
            result = true;
        }
        return result;
    }

    public ConcurrentHashMap<Integer, User> findAll() {
        return logic.findAll();
    }

    public User getUser(int id) {
        User user = null;
        if (logic.findById(id)) {
            user = logic.getUser(id);
        }
        return user;
    }

}
