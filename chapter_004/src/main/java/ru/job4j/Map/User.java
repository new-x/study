package ru.job4j.Map;

import java.util.Calendar;
import java.util.Objects;

public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, children, birthday);
    }
}
