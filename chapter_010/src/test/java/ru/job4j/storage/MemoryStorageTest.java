package ru.job4j.storage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.model.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MemoryStorageTest {

    @Test
    public void addUserOnMemoryStorage() {
        User user = new User("Kirill");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storage storage = (Storage) context.getBean("memoryStorage");
        storage.add(user);
        assertThat(storage.get(0), is(user));
    }
}