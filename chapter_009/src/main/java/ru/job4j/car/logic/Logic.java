package ru.job4j.car.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.car.CarPlatform;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.*;
import ru.job4j.car.work.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Logic<T extends CarPlatform> {
    private static final Logger LOGGER = LogManager.getLogger(Logic.class);
    private final AdDAO adDAO;
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final CarDAO carDAO;
    private final ControllerDAO controllerDAO = new ControllerDAO() {};

    public Logic() {
        this.adDAO = AdDAO.getINSTANCE();
        this.userDAO = UserDAO.getINSTANCE();
        this.roleDAO = RoleDAO.getINSTANCE();
        this.carDAO = CarDAO.getINSTANCE();
    }

    public List<T> getAll(T object) {
            return this.controllerDAO.getAll(object);
    }

    public void addOrUpdate(T object) {
        if (object != null) {
            this.controllerDAO.addOrUpdate(object);
        }
    }

    public T getById(T object) {
        if (object.getId() != 0) {
            object = (T) this.controllerDAO.getById(object);
        }
        return object;
    }

    public List<T> getAllByType(String type) {
        List<T> result = null;
        if (type.equals("body")) {
            result = this.controllerDAO.getAll(new Body());
        } else if (type.equals("brand")) {
            result = this.controllerDAO.getAll(new Brand());
        } else if (type.equals("color")) {
            result = this.controllerDAO.getAll(new Color());
        } else if (type.equals("engine")) {
            result = this.controllerDAO.getAll(new Engine());
        } else if (type.equals("transmission")) {
            result = this.controllerDAO.getAll(new Transmission());
        }
        return result;
    }

    public User getUserByLogin(User user) {
        if (user.getLogin() != null) {
            return this.userDAO.getUserByLogin(user.getLogin());
        }
        return null;
    }

    public Auth checkUserAuth(HttpSession session, Auth auth) {
        Auth outAuth = new Auth();
        if (session.getAttribute("login") == null) {
            if (auth.getMessage().equals("authUser")) {
                if (auth.getLogin() != null) {
                    User user = this.userDAO.getUserByLogin(auth.getLogin());
                    if (user != null) {
                        if (user.getPassword().equals(auth.getPassword())) {
                            session.setAttribute("login", user.getLogin());
                            outAuth.setLogin(user.getLogin());
                            outAuth.setMessage("Auth Successfully");
                        } else {
                            outAuth.setMessage("Error Password");
                        }
                    } else {
                        outAuth.setMessage("Error Login or Password");
                    }
                }
            } else {
                outAuth.setMessage("Error Auth");
            }
        } else if (session.getAttribute("login") != null) {
            if (auth.getMessage().equals("authClose")) {
                session.invalidate();
                outAuth.setMessage("Session close.");
            }
        }
        return outAuth;
    }

    public boolean checkAdByUser(Ad ad, User user) {
        boolean result = false;
        if (user.getLogin() != null) {
            if (((Ad) this.controllerDAO.getById(ad)).getUser().getId() == this.userDAO.getUserByLogin(user.getLogin()).getId()) {
                result = true;
            }
        }
        return result;
    }

    public List<Ad> getAllAdsByFilter(Filter filter){
        return adDAO.getAllAdsByFilter(filter);
    };
}
