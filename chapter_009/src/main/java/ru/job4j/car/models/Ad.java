package ru.job4j.car.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "Ad")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "price")
    private Integer price;
    @Column(name = "done")
    private boolean done;
    @Column(name = "description")
    private String description;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar calendar;

    public Ad() {
    }

    public Ad(User user, Car car, Integer price, String description, Calendar calendar) {
        this.user = user;
        this.car = car;
        this.price = price;
        this.description = description;
        this.calendar = calendar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", user=" + user +
                ", car=" + car +
                ", price=" + price +
                ", done=" + done +
                ", description='" + description + '\'' +
                ", calendar=" + calendar +
                '}';
    }
}
