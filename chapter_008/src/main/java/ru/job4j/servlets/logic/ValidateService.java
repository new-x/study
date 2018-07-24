package ru.job4j.servlets.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.servlets.data.MemoryStore;
import ru.job4j.servlets.data.Store;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.logic
 * Create data: 23.07.2018 17:08
 */

public class ValidateService<K, V> {
    private static final Logger Log = LoggerFactory.getLogger(ValidateService.class);
    private static final ValidateService INSTANCE = new ValidateService();
    private final Store logic = MemoryStore.getInstance();

    public static synchronized ValidateService getInstance() {
        return INSTANCE;
    }

    public void add(int id, String name, String login, String email) {
        logic.add(id, name, login, email);
    }

    public void update(int id, String name, String login, String email) {
        if (logic.findById(id)) {
            logic.update(id, name, login, email);
        }

    }

    public void delete(int id) {
        if (logic.findById(id)) {
            logic.delete(id);
        }
    }

    public ConcurrentHashMap<K, V> findAll() {
        return logic.findAll();
    }


    public boolean checkInt(String id) {
        try {
            String regex = "\\d+";
            if (id.matches(regex)) {
                return true;
            }
        } catch (NullPointerException e) {
            Log.error(e.getMessage(), e);
        }
        return false;
    }

}
