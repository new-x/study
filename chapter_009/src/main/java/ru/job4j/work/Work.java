package ru.job4j.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import ru.job4j.data.Data;
import ru.job4j.models.Item;
import ru.job4j.servlets.GeneralServelet;

import java.util.ArrayList;
import java.util.List;

public class Work {
    private static final Logger LOGGER = LogManager.getLogger(Work.class);
    private static Data data = Data.getINSTANCE();
    private static final Session session = data.getSessionFactory().openSession();
    private static final Work INSTANCE = new Work();

    public static Work getINSTANCE() {
        return INSTANCE;
    }

    public void addItem(Item item) {
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    public Item getItem(Item item) {
        session.beginTransaction();
        if (item.getId() != 0) {
            item = session.get(Item.class, item.getId());
        } else {
            item = session.get(Item.class, item.getDescription());
        }
        session.getTransaction().commit();
        return item;
    }

    public void deleteItem(Item item) {
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }

    public void updateItem(Item item) {
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }

    public List<Item> getAllItems() {
        //session.beginTransaction();
        LOGGER.info("Достаем все Items.");
        return session.createQuery("From " + Item.class.getSimpleName()).list();
    }

    public void close() {
        if (session != null) {
            session.close();
        }
    }
}
