package ru.job4j.car.models.onxml;

public class Engine {
    private int id;
    private String type;

    public Engine() {
    }

    public Engine(String type) {
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
