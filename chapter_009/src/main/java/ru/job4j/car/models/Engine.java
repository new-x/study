package ru.job4j.car.models;

import ru.job4j.car.CarModel;

import javax.persistence.*;

@Entity
@Table(name = "engine")
public class Engine implements CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    private String name;

    public Engine() {
    }

    public Engine(String name) {
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

    public void setName(String type) {
        this.name = type;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
