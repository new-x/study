package ru.job4j.car.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User implements CarPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User() {
    }

    public User(String login) {
        this.login = login;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @JsonIgnore
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, name, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
