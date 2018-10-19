package ru.job4j.car.models;

import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car implements CarPlatform {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(image, car.image) &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(color, car.color) &&
                Objects.equals(body, car.body) &&
                Objects.equals(engine, car.engine) &&
                Objects.equals(transmission, car.transmission);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, image, brand, color, body, engine, transmission);
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
