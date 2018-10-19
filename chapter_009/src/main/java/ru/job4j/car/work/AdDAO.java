package ru.job4j.car.work;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.ControllerDAO;
import ru.job4j.car.models.Ad;
import ru.job4j.car.models.Filter;

import java.util.List;

public class AdDAO extends ControllerDAO {
    private static final AdDAO INSTANCE = new AdDAO();
    private final TransactionWrapper transactionWrapper = TransactionWrapper.getINSTANCE();
    private static final Logger LOGGER = LogManager.getLogger(AdDAO.class);

    public static AdDAO getINSTANCE() {
        return INSTANCE;
    }

    public List<Ad> getAllAdsByFilter(Filter filter) {
        return this.transactionWrapper.writeAndExecute(session ->
                session.createQuery("from Ad where" +
                        "(true = :checkDateFirst or (:dateFilterFirst < calendar)) and " +
                        "(true  = :checkDateSecond or (:dateFilterSecond > calendar)) and " +
                        "(true = :brandCheck or (:brandFilter = car.brand)) and " +
                        "(true = :filterPhoto or (car.image is not null))", Ad.class)
                        .setParameter("checkDateFirst", filter.getCalendarFirst() == null)
                        .setParameter("dateFilterFirst", filter.getCalendarFirst())
                        .setParameter("checkDateSecond", filter.getCalendarSecond() == null)
                        .setParameter("dateFilterSecond", filter.getCalendarSecond())
                        .setParameter("brandCheck", filter.getBrand() == null)
                        .setParameter("brandFilter", filter.getBrand())
                        .setParameter("filterPhoto", !filter.isWithPhoto())
                        .list()
        );
    }
}
