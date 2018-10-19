package ru.job4j.car.work;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.CarModel;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.*;

import java.util.Calendar;

import static org.junit.Assert.assertTrue;

public class WorkerTest<T extends CarModel> {
    private Logic logic;

    @Before
    public void init() {
        this.logic = new Logic();
    }

    @Test
    public void testAddAd() {
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
        Calendar calendar = Calendar.getInstance();
        Car car = new Car(brand, color, body, engine, transmission);
        Ad ad = new Ad(user, car, 100, "About car.", calendar);
        logic.addOrUpdate(ad);
        assertTrue(logic.getById(ad).getId() == ad.getId());
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
        assertTrue(user.getLogin().equals("root"));
    }

    @Test
    public void testUpdateAdd() {
        User user = null;
        user = logic.getUserByLogin(new User("root"));
        Body body = new Body();
        Brand brand = new Brand();
        Color color = new Color();
        Engine engine = new Engine();
        Transmission transmission = new Transmission();
        body.setId(2);
        brand.setId(2);
        color.setId(2);
        engine.setId(2);
        transmission.setId(2);
        Calendar calendar = Calendar.getInstance();
        Car car = new Car(brand, color, body, engine, transmission);
        Ad ad = new Ad(user, car, 100, "About car.", calendar);
        logic.addOrUpdate(ad);
        ad.setDone(true);
        logic.addOrUpdate(ad);
        assertTrue(((Ad) logic.getById(ad)).isDone() == ad.isDone());
    }
}
