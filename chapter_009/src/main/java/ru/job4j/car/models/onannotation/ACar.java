package ru.job4j.car.models.onannotation;

import ru.job4j.car.CarModel;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class ACar implements CarModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "body_id")
    private ABody body;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engine_id")
    private AEngine engine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transmission_id")
    private ATransmission transmission;

    public ACar() {

    }

    public ACar(String name, ABody body, AEngine engine, ATransmission transmission) {
        this.name = name;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public ACar(int id) {
        this.id = id;
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

    public ABody getBody() {
        return body;
    }

    public void setBody(ABody body) {
        this.body = body;
    }

    public AEngine getEngine() {
        return engine;
    }

    public void setEngine(AEngine engine) {
        this.engine = engine;
    }

    public ATransmission getTransmission() {
        return transmission;
    }

    public void setTransmission(ATransmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "ACar{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
