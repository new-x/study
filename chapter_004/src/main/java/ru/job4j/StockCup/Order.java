package ru.job4j.StockCup;

import java.util.Objects;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.StockCup
 * Create data: 06.03.2018 14:17
 */

public class Order<E> implements Comparable<Order>  {
    protected int id; // id number from Order
    protected String book; // name security paper
    protected String action; //sale or buy order
    protected Integer price;
    protected Integer volume;

    public Order(int id, String book, String action, int price, int volume) {
        this.id = id;
        this.book = book;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", book='" + book + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return o.price.compareTo(this.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order<?> order = (Order<?>) o;
        return Objects.equals(book, order.book);
    }

    @Override
    public int hashCode() {

        return Objects.hash(book);
    }
}
