package ru.job4j.car.models;

import ru.job4j.car.CarModel;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "brand")
public class Brand implements CarPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "brand")
    private String name;

    public Brand() {
    }

    public Brand(String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return id == brand.id &&
                Objects.equals(name, brand.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
