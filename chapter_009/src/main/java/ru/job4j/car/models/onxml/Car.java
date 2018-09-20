package ru.job4j.car.models.onxml;

import ru.job4j.car.CarModel;

public class Car implements CarModel{
    private int id;
    private String name;
    private Body body;
    private Engine engine;
    private Transmission transmission;

    public Car() {

    }

    public Car(String name, Body body, Engine engine, Transmission transmission) {
        this.name = name;
        this.body = body;
        this.engine = engine;
        this.transmission = transmission;
    }

    public Car(int id) {
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
        return "ACar{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
