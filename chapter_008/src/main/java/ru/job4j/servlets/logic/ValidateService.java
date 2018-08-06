package ru.job4j.servlets.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.Store;
import ru.job4j.servlets.data.User;

import java.util.List;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.store
 * Create data: 23.07.2018 17:08
 */

public class ValidateService {
    private static final Logger Log = LoggerFactory.getLogger(ValidateService.class);
    private static final ValidateService INSTANCE = new ValidateService();
    private final Store store = DBStore.getInstance();

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    private ValidateService(){}
    public void add(User user) {
        store.add(user);
    }

    public void update(User user) {
        if (store.findById(user.getId()) != null && store.findById(user.getId()).getId() == user.getId()) {
            store.update(user);
        }
    }

    public boolean delete(int id) {
        boolean result = false;
        if (store.findById(id) != null && store.findById(id).getId() == id) {
            store.delete(id);
            result = true;
        }
        return result;
    }

    public List<User> findAll() {
        return store.findAll();
    }

    public User getUser(int id) {
        return store.findById(id);
    }

    public List<Role> getRoles() {
        return store.getAllRoles();
    }

    public User findByLogin(String login) {
        return store.findByLogin(login);
    }

    public boolean isCredentional(String login, String password) {
        boolean result = false;
        List<User> allUsers = store.findAll();
        for (User user : allUsers) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
