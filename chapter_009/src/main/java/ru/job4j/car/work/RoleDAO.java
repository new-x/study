package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.Role;

public class RoleDAO extends ControllerDAO {
    private static final RoleDAO INSTANCE = new RoleDAO();
    private final TransactionWrapper transactionWrapper = TransactionWrapper.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(RoleDAO.class);

    public static RoleDAO getINSTANCE() {
        return INSTANCE;
    }
}
