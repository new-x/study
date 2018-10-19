package ru.job4j.car.models;

import java.util.Calendar;

public class Filter  {
    private Brand brand;
    private boolean withPhoto;
    private Calendar calendarFirst;
    private Calendar calendarSecond;

    public Calendar getCalendarFirst() {
        return calendarFirst;
    }

    public void setCalendarFirst(Calendar calendarFirst) {
        this.calendarFirst = calendarFirst;
    }

    public Calendar getCalendarSecond() {
        return calendarSecond;
    }

    public void setCalendarSecond(Calendar calendarSecond) {
        this.calendarSecond = calendarSecond;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isWithPhoto() {
        return withPhoto;
    }

    public void setWithPhoto(boolean withPhoto) {
        this.withPhoto = withPhoto;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "brand=" + brand +
                ", withPhoto=" + withPhoto +
                ", calendarFirst=" + calendarFirst +
                ", calendarSecond=" + calendarSecond +
                '}';
    }
}
