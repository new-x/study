package ru.job4j.car.models.onxml;

public class Body {
    private int id;
    private String color;

    public Body() {
    }

    public Body(String color) {
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
