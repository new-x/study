package ru.job4j.convertlisttomap;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by aleks on 17.09.2017.
 */
public class ConvertlisttomapTest {
    @Test
    public void convertUserListtoHashMap() {
        Convertlisttomap convert = new Convertlisttomap();
        List<User> userList = new LinkedList<>();
        userList.add(new User(0, "Петя", "Москва"));
        userList.add(new User(1, "Дарья", "Самара"));
        userList.add(new User(2, "Владимир", "Липецк"));
        userList.add(new User(3, "Павел", "Сочи"));
        userList.add(new User(4, "Максим", "Белгород"));
        HashMap<Integer, User> result = convert.convertUser(userList);
    }
}
