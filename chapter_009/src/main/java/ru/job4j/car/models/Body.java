package ru.job4j.car.models;

import ru.job4j.car.CarModel;

import javax.persistence.*;

@Entity
@Table(name = "body")
public class Body implements CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "body")
    private String name;

    public Body() {
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
    public String toString() {
        return "Body{" +
                "id=" + id +
                ", body='" + name + '\'' +
                '}';
    }
}
