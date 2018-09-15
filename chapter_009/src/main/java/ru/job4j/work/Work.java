package ru.job4j.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.job4j.data.Data;
import ru.job4j.models.Item;

import java.util.List;
import java.util.function.Function;

public class Work {
    private static final Logger LOGGER = LogManager.getLogger(Work.class);
    private static final Data data = Data.getINSTANCE();
    private static final Work INSTANCE = new Work();

    public static Work getINSTANCE() {
        return INSTANCE;
    }

    private <T> T tx(Function<Session, T> command) {
        final Session session = data.getSessionFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            result = command.apply(session);
            transaction.commit();
        } catch (final Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public void addItem(final Item item) {
        this.tx(session -> {
            session.save(item);
            return null;
        });
    }

    public Item getItem(final Item item) {
        return this.tx(session -> {
            Item newItem = null;
            if (item.getId() != 0) {
                newItem = session.get(Item.class, item.getId());
            } else {
                newItem = session.get(Item.class, item.getDescription());
            }
            return newItem;
        });
    }

    public void deleteItem(Item item) {
        this.tx(session -> {
            session.delete(item);
            return true;
        });
    }

    public void updateItem(Item item) {
            this.tx(session -> {
                session.update(item);
                return true;
            });

    }

    public List<Item> getAllItems() {
        return this.tx(session -> session.createQuery("From " + Item.class.getSimpleName()).list());
    }

}
