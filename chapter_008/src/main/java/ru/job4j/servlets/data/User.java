package ru.job4j.servlets.data;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 23.07.2018 16:49
 */

public class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String email;
    private Calendar createDate;
    private Role role;

    public User(int id, String name, String login, String password, String email, Calendar createDate, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.role = role;
    }

    public User(String name, String login, String password, String email, Calendar createDate) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
    }

    public User(int id, String name, String login, String password, String email) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public Role getRole() {
        return role;
    }
    public String getPassword() {
        return password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login = " + login +
                ", password = " + password +
                ", name = " + name  +
                ", email = " + email +
                ", createDate = " + createDate.getTime() +
                ", roleID = " + role.getId() +
                ", roleName = " + role.getName() +
                '}';
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
