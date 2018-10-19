package ru.job4j.car.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.job4j.car.CarModel;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transmission")
public class Transmission implements CarPlatform {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transmission that = (Transmission) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Transmission{" +
                "id=" + id +
                ", type='" + name + '\'' +
                '}';
    }
}
