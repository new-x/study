package ru.job4j.car.work;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.models.*;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class WorkerStorageTest {
    private AdDAO adDAO;
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    private CarDAO carDAO;
    private Role role;
    private User user;
    private Ad ad;
    private Car car;
    private Brand brand;
    private Color color;
    private Body body;
    private Engine engine;
    private Transmission transmission;
    private Calendar calendar;

    @Before
    public void init() {
        this.adDAO = AdDAO.getINSTANCE();
        this.userDAO = UserDAO.getINSTANCE();
        this.roleDAO = RoleDAO.getINSTANCE();
        this.carDAO = CarDAO.getINSTANCE();
        this.role = new Role("Admin");
        this.user = new User("root", "root");
        this.user.setRole(role);
        this.brand = new Brand("BMW");
        this.color = new Color("Red");
        this.body = new Body("Coupe");
        this.engine = new Engine("Diesel");
        this.transmission = new Transmission("Automatic");
        this.car = new Car(this.brand, this.color, this.body, this.engine, this.transmission);
        this.calendar = Calendar.getInstance();
        this.calendar.set(2018, 9, 19, 24, 20, 30);
        this.ad = new Ad(this.user, this.car, 500, "desc", this.calendar);
        this.roleDAO.addOrUpdate(this.role);
        this.userDAO.addOrUpdate(this.user);
        this.userDAO.addOrUpdate(this.brand);
        this.userDAO.addOrUpdate(this.color);
        this.userDAO.addOrUpdate(this.body);
        this.userDAO.addOrUpdate(this.engine);
        this.userDAO.addOrUpdate(this.transmission);
        this.userDAO.addOrUpdate(this.car);
        this.adDAO.addOrUpdate(this.ad);
    }

    @Ignore
    @Test
    public void getUserByLogin() {
        assertTrue(this.userDAO.getUserByLogin(user.getLogin()).getLogin().equals("root"));
    }
    @Ignore
    @Test
    public void getAllByFilter() {
        Filter filter = new Filter();
        filter.setBrand(this.brand);
        assertTrue(this.adDAO.getAllAdsByFilter(filter).contains(this.ad));
    }

}
