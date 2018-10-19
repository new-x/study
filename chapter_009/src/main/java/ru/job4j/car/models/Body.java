package ru.job4j.car.models;

import ru.job4j.car.CarModel;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "body")
public class Body implements CarPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "body")
    private String name;

    public Body() {
    }

    public Body(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String body) {
        this.name = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return id == body.id &&
                Objects.equals(name, body.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Body{" +
                "id=" + id +
                ", body='" + name + '\'' +
                '}';
    }
}
