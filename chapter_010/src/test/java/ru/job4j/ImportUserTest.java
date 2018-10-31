package ru.job4j;

import org.junit.Test;
import ru.job4j.model.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImportUserTest {
    @Test
    public void testMemoryStorage() {
        User user = new User("Kirill");
        ImportUser importUser = new ImportUser("spring-context.xml", "memoryStorage");
        importUser.addUser(user);
        assertThat(importUser.getUser(0), is(user));
    }

}