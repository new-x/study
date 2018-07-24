package ru.job4j.servlets.data;

import java.util.Calendar;
import java.util.Objects;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 23.07.2018 16:49
 */

public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Calendar createDate;

    public User(int id, String name, String login, String email, Calendar createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", login = '" + login + '\'' +
                ", email = '" + email + '\'' +
                ", createDate = " + createDate.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(email, user.email) &&
                Objects.equals(createDate, user.createDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, login, email, createDate);
    }
}
