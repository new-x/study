package ru.job4j.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;

import java.util.List;

public abstract class ControllerDAO<T extends CarPlatform> {
    private static final TransactionWrapper transactionWrapper = TransactionWrapper.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(ControllerDAO.class);

    public int addOrUpdate(T object){
        return transactionWrapper.writeAndExecute(session -> {
            session.saveOrUpdate(object);
            return object.getId();
        });
    };

    public T getById(T object){
        return (T) this.transactionWrapper.writeAndExecute(session -> session.get(object.getClass(), object.getId()));
    };

    public List<T> getAll(T object) {
        return this.transactionWrapper.writeAndExecute(session -> session.createQuery("from " + object.getClass().getSimpleName()).list());
    };
}
