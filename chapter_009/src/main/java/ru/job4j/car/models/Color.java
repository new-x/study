package ru.job4j.car.models;

import ru.job4j.car.CarModel;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "color")
public class Color implements CarPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "color")
    private String name;

    public Color() {
    }

    public Color(String name) {
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

    public void setName(String color) {
        this.name = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return id == color.id &&
                Objects.equals(name, color.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + name + '\'' +
                '}';
    }
}
