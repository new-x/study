package ru.job4j.storage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.job4j.model.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class JbdcStorageTest {
    @Test
    public void tetsAddUserOnDb() {
        User user = new User("Kirill");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        JbdcStorage jbdcStorage = context.getBean(JbdcStorage.class);
        jbdcStorage.add(user);
        assertThat(jbdcStorage.get(1).getName(), is(user.getName()));
    }

}