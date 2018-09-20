package ru.job4j.car.models.onannotation;

import javax.persistence.*;

@Entity
@Table(name = "transmission")
public class ATransmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "type")
    private String type;

    public ATransmission() {
    }

    public ATransmission(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
