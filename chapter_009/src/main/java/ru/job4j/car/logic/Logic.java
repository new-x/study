package ru.job4j.car.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.CarModel;
import ru.job4j.car.models.*;
import ru.job4j.car.work.Worker;

import javax.servlet.http.HttpSession;
import java.util.List;

public class Logic<T extends CarModel> {
    private static final Logger LOGGER = LogManager.getLogger(Logic.class);
    private final Worker worker;

    public Logic(TransactionWrapper transactionWrapper) {
        this.worker = new Worker(transactionWrapper);
    }

    public void addOrUpdateAd(Ad ad) {
        if (ad != null) {
            worker.addOrUpdateAd(ad);
        }
    }

    public Ad getAddById(Ad ad) {
        if (ad.getId() != 0) {
            ad = worker.getAdById(ad);
        }
        return ad;
    }

    public List<T> getAll(String type) {
        List<T> result = null;
        if (type.equals("body")) {
            result = worker.getAll(new Body());
        } else if (type.equals("brand")) {
            result = worker.getAll(new Brand());
        } else if (type.equals("color")) {
            result = worker.getAll(new Color());
        } else if (type.equals("engine")) {
            result = worker.getAll(new Engine());
        } else if (type.equals("transmission")) {
            result = worker.getAll(new Transmission());
        }
        return result;
    }

    public List<Ad> getAllAds() {
        return worker.getAllAds();
    }

    public List<Car> getAllCars() {
        return worker.getAllCars();
    }

    public User getUserByLogin(User user) {
        if (user.getLogin() != null) {
            return worker.getUserByLogin(user);
        }
        return null;
    }

    public Auth checkUserAuth(HttpSession session, Auth auth) {
        Auth outAuth = new Auth();
        if (session.getAttribute("login") == null) {
            if (auth.getMessage().equals("authUser")) {
                if (auth.getLogin() != null) {
                    User user = worker.getUserByLogin(new User(auth.getLogin()));
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
            if (worker.getAdById(ad).getUser().getId() == worker.getUserByLogin(user).getId()) {
                result = true;
            }
        }
        return result;
    }
}
