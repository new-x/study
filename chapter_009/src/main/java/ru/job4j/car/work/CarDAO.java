package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.CarModel;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.Car;

import javax.sound.sampled.Control;
import java.util.List;

public class CarDAO<T extends CarModel> extends ControllerDAO {
    private static final CarDAO INSTANCE = new CarDAO();
    private final TransactionWrapper transactionWrapper = TransactionWrapper.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(CarDAO.class);

    public static CarDAO getINSTANCE() {
        return INSTANCE;
    }

}
