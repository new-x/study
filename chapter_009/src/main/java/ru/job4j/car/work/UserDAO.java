package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.User;

import javax.persistence.NoResultException;

public class UserDAO extends ControllerDAO {
    private static final UserDAO INSTANCE = new UserDAO();
    private final TransactionWrapper transactionWrapper = TransactionWrapper.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(UserDAO.class);

    public static UserDAO getINSTANCE() {
        return INSTANCE;
    }

    public User getUserByLogin(String login) {
        return this.transactionWrapper.writeAndExecute(session -> {
            User newUser = null;
            try {
                newUser = (User) session.createQuery("from User user where user.login = :userLogin")
                        .setParameter("userLogin", login)
                        .getSingleResult();
            } catch (NoResultException e) {
                LOGGER.error(e.getMessage());
            }
            return newUser;
        });
    }
}
