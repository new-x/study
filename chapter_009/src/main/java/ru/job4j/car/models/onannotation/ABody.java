package ru.job4j.car.models.onannotation;

import ru.job4j.car.CarModel;

import javax.persistence.*;

@Entity
@Table(name = "body")
public class ABody implements CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "color")
    private String color;

    public ABody() {
    }

    public ABody(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
