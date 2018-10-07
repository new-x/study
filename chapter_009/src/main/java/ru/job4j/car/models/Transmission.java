package ru.job4j.car.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.job4j.car.CarModel;

import javax.persistence.*;

@Entity
@Table(name = "transmission")
public class Transmission implements CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type")
    private String name;

    public Transmission() {
    }

    public Transmission(String name) {
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
        return "Transmission{" +
                "id=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
