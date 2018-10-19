package ru.job4j.car.models;

import ru.job4j.car.CarPlatform;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "Ad")
public class Ad implements CarPlatform {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ad ad = (Ad) o;
        return id == ad.id &&
                done == ad.done &&
                Objects.equals(user, ad.user) &&
                Objects.equals(car, ad.car) &&
                Objects.equals(price, ad.price) &&
                Objects.equals(description, ad.description) &&
                Objects.equals(calendar, ad.calendar);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, car, price, done, description, calendar);
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
