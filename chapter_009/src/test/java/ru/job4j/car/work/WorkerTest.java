package ru.job4j.car.work;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.CarModel;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WorkerTest<T extends CarModel> {
    private TransactionWrapper transactionWrapper;
    private Logic logic;
    private Worker worker;

    @Before
    public void init() {
        this.transactionWrapper = new TransactionWrapper();
        this.logic = new Logic(this.transactionWrapper);
        this.worker = new Worker(this.transactionWrapper);
    }

    @Test
    public void addAd() {
        User user = null;
        user = logic.getUserByLogin(new User("root"));
        Body body = new Body();
        Brand brand = new Brand();
        Color color = new Color();
        Engine engine = new Engine();
        Transmission transmission = new Transmission();
        body.setId(1);
        brand.setId(1);
        color.setId(1);
        engine.setId(1);
        transmission.setId(1);
        Car car = new Car(brand, color, body, engine, transmission);
        Ad ad = new Ad(user, car, 100, "About car.");
        logic.addOrUpdateAd(ad);
    }

    @Test
    public void getAll() {
        List<T> transmissions = logic.getAll("Brand");
        for (T type : transmissions) {
            System.out.println(type);
        }
    }

    @Test
    public void testAdByUser() {
        Ad ad = new Ad();
        ad.setId(1);
        User user = new User("root");
        boolean result = this.logic.checkAdByUser(ad, user);
        assertTrue(result);
    }

    @Test
    public void testGetUserByLogin() {
        User user = new User();
        user.setLogin("root");
        user = logic.getUserByLogin(user);
        System.out.println(user);
    }

    @Test
    public void getAllCar() {
        List<Car> cars = this.logic.getAllCars();
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Test
    public void getAllAds() {
        List<Ad> ads = this.logic.getAllAds(new Filter());
        for (Ad ad : ads) {
            System.out.println(ad);
        }
    }

    @Test
    public void getByFilter() {
        Filter filter = new Filter();
        Brand brand = new Brand();
        brand.setId(1);
        //filter.setCalendarSecond(Calendar.getInstance());
        //Calendar calendarFirst = Calendar.getInstance();
        //calendarFirst.set(2018, Calendar.OCTOBER, 9);
        //filter.setCalendarFirst(calendarFirst);
        //filter.setBrand(brand);
        //filter.setWithPhoto(true);
        List<Ad> ads = this.worker.findByFilter(filter);
        for (Ad ad : ads) {
            System.out.println(ad);
        }
    }
}
