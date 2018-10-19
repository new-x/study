package ru.job4j.car.models;

import ru.job4j.car.CarModel;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "engine")
public class Engine implements CarPlatform {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return id == engine.id &&
                Objects.equals(name, engine.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
