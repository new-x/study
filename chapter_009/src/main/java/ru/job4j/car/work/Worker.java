package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.CarModel;
import ru.job4j.car.models.Ad;
import ru.job4j.car.models.Car;
import ru.job4j.car.models.User;

import javax.persistence.NoResultException;
import java.util.List;

public class Worker<T extends CarModel> {
    private static final Logger LOGGER = LogManager.getLogger(Worker.class);
    private TransactionWrapper transactionWrapper;

    public Worker(TransactionWrapper transactionWrapper) {
        this.transactionWrapper = transactionWrapper;
    }

    public void addOrUpdateAd(Ad ad) {
        this.transactionWrapper.writeAndExecute(session -> {
            session.saveOrUpdate(ad);
            return ad.getId();
        });
    }

    public List<T> getAll(T type) {
        return (List<T>) this.transactionWrapper.writeAndExecute(session -> session.createQuery("from " + type.getClass().getSimpleName()).list());
    }

    public User getUserByLogin(final User user) {
        return this.transactionWrapper.writeAndExecute(session -> {
            User newUser = null;
            try {
                newUser = (User) session.createQuery("from User user where user.login = :userLogin")
                        .setParameter("userLogin", user.getLogin())
                        .getSingleResult();
            } catch (NoResultException e){
                LOGGER.error(e.getMessage());
            }
            return newUser;
        });
    }

    public List<Car> getAllCars() {
        return this.transactionWrapper.writeAndExecute(session -> session.createQuery("from " + Car.class.getSimpleName()).list());
    }

    public List<Ad> getAllAds() {
        return this.transactionWrapper.writeAndExecute(session -> session.createQuery("from " + Ad.class.getSimpleName()).list());
    }

    public Ad getAdById(Ad ad) {
        return this.transactionWrapper.writeAndExecute(session -> session.get(Ad.class, ad.getId()));
    }
}
