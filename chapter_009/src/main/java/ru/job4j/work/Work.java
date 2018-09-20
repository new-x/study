package ru.job4j.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.job4j.TransactionWrapper;
import ru.job4j.data.Data;
import ru.job4j.models.Item;

import java.util.List;
import java.util.function.Function;

public class Work {
    private static final Logger LOGGER = LogManager.getLogger(Work.class);
    private static final Work INSTANCE = new Work();
    private final TransactionWrapper transactionWrapper;

    public static Work getINSTANCE() {
        return INSTANCE;
    }

    public Work() {
        this.transactionWrapper = new TransactionWrapper();

    }

    public void addItem(final Item item) {
        this.transactionWrapper.writeAndExecute(session -> {
            session.save(item);
            return null;
        });
    }

    public Item getItem(final Item item) {
        return this.transactionWrapper.writeAndExecute(session -> {
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
        this.transactionWrapper.writeAndExecute(session -> {
            session.delete(item);
            return true;
        });
    }

    public void updateItem(Item item) {
            this.transactionWrapper.writeAndExecute(session -> {
                session.update(item);
                return true;
            });

    }

    public List<Item> getAllItems() {
        return this.transactionWrapper.writeAndExecute(session -> session.createQuery("From " + Item.class.getSimpleName()).list());
    }

}
