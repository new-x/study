package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.CarModel;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Work <T extends CarModel> {
    private static final Logger LOGGER = LogManager.getLogger(Work.class);
    private final TransactionWrapper transactionWrapper;
    private Class genericClass;

    public Work(TransactionWrapper transactionWrapper) {
        this.transactionWrapper = transactionWrapper;
        this.genericClass = (Class)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public int add(T carModel) {
        return this.transactionWrapper.writeAndExecute(session -> {
            session.save(carModel);
            return carModel.getId();
        });
    }

    public void delete(T carModel) {
        this.transactionWrapper.writeAndExecute(session -> {
            session.delete(carModel);
            return true;
        });
    }

    public void update(T carModel) {
        this.transactionWrapper.writeAndExecute(session -> {
            session.update(carModel);
            return true;
        });
    }

    public T findById(int id){
        return (T) this.transactionWrapper.writeAndExecute(session -> session.get(this.genericClass, id));
    }

    public List<T> getAllCars() {
        return this.transactionWrapper.writeAndExecute(session -> session.createQuery("from " + this.genericClass.getSimpleName(), this.genericClass).list());
    }

}
