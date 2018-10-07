package ru.job4j.car.models;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "image")
    String image;
    @ManyToOne
    @JoinColumn
    private Brand brand;
    @ManyToOne
    @JoinColumn
    private Color color;
    @ManyToOne
    @JoinColumn
    private Body body;
    @ManyToOne
    @JoinColumn
    private Engine engine;
    @ManyToOne
    @JoinColumn
    private Transmission transmission;

    public Car() {

    }

    public Car(Brand brand, Color color, Body body, Engine engine, Transmission transmission) {
        this.brand = brand;
        this.color = color;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", brand=" + brand +
                ", color=" + color +
                ", body=" + body +
                ", engine=" + engine +
                ", transmission=" + transmission +
                '}';
    }
}
