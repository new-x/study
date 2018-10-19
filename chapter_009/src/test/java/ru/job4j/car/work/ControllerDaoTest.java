package ru.job4j.car.work;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.Role;
import ru.job4j.car.models.User;

public class ControllerDaoTest {
    private ControllerDAO controllerDAO = new ControllerDAO() {};
    private Role role;

    @Before
    public void init() {
        this.role= new Role("Admin");
        this.role.setId(controllerDAO.addOrUpdate(role));
    }

    @Test
    public void addUserOnDb() {
        User user = new User("root", "root");
        user.setRole(this.role);
        int userId = this.controllerDAO.addOrUpdate(user);
        user.setId(userId);
        assertTrue(((User)this.controllerDAO.getById(user)).getLogin().equals("root"));
    }

    @Test
    public void getById(){
        assertTrue(((Role) this.controllerDAO.getById(this.role)).getDescription().equals("Admin"));
    }

    @Test
    public void getAll() {
        Role testRole = (Role) this.controllerDAO.getById(role);
        assertTrue(this.controllerDAO.getAll(role).contains(testRole));
    }
}
