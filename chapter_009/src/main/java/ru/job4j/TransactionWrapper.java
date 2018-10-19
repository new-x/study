package ru.job4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.data.Data;
import ru.job4j.work.Work;

import java.util.function.Function;

public class TransactionWrapper {
    private static final Data data = Data.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(TransactionWrapper.class);
    private static final TransactionWrapper INSTANCE = new TransactionWrapper();

    public static TransactionWrapper getINSTANCE() {
        return INSTANCE;
    }

    public  <T> T writeAndExecute(Function<Session, T> command) {
        final Session session = data.getSession();
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
}
