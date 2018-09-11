package ru.job4j.models;

import java.sql.Timestamp;
import java.util.Objects;

public class Item {
    private int id;
    private String description;
    private boolean done;
    private Timestamp creatdata;

    public Item() {
    }

    public Item(int id, String description, boolean done, Timestamp creatdata) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.creatdata = creatdata;
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Timestamp getCreatdata() {
        return creatdata;
    }

    public void setCreatdata(Timestamp creatdata) {
        this.creatdata = creatdata;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                done == item.done &&
                Objects.equals(description, item.description) &&
                Objects.equals(creatdata, item.creatdata);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, done, creatdata);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", done=" + done +
                ", creatdata=" + creatdata +
                '}';
    }
}
