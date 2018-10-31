package ru.job4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.model.User;
import ru.job4j.storage.JbdcStorage;
import ru.job4j.storage.Storage;

public class ImportUser {
    private final Logger Log = LoggerFactory.getLogger(JbdcStorage.class);
    private final ApplicationContext context;
    private final Storage storage;

    public ImportUser(String springConfig, String storageType) {
        this.context = new ClassPathXmlApplicationContext(springConfig);
        if (storageType.equals("jdbcStorage")) {
            this.storage = (Storage) this.context.getBean(storageType);
        } else if (storageType.equals("memoryStorage")) {
            this.storage = (Storage) this.context.getBean(storageType);
        } else {
            throw new RuntimeException("Storage is not initialization.");
        }
    }

    public void addUser(User user) {
        if (user != null) {
            this.storage.add(user);
        }
    }

    public User getUser(int index) {
        return this.storage.get(index);
    }
}
