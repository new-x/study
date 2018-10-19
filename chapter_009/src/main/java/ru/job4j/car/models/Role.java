package ru.job4j.car.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GeneratorType;
import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role")
public class Role implements CarPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "description")
    private String description;

    public Role() {
    }

    public Role(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
