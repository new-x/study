package ru.job4j.tracker.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.models.Item;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Class Tracker.
 *
 * @author alekseev
 * @since mm-dd-yyyy
 */

public class Tracker implements AutoCloseable {
    /**
     * Init Logger
     */
    private static final Logger Log = LoggerFactory.getLogger(Tracker.class);
    /*
    * Init SQL Connection.
     */
    private Connection connection;
    /*
    * Config DB.
     */
    private Properties config;
    /*
     * Sql requests.
     */
    private Properties sqlrequest;

    public void init() {
        InputStream path = getClass().getClassLoader().getResourceAsStream("config.properties");
        InputStream sql = getClass().getClassLoader().getResourceAsStream("sqlrequest.properties");
        this.config = new Properties();
        this.sqlrequest = new Properties();
        try {
            this.config.load(path);
            this.sqlrequest.load(sql);
            this.connection = DriverManager.getConnection(
                    this.config.getProperty("db.host"),
                    this.config.getProperty("db.user"),
                    this.config.getProperty("db.password"));
            try(PreparedStatement ps = findRequest("create.table")) {
                ps.execute();
            }
        } catch (IOException e) {
            Log.error(e.getMessage(), e);
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    private PreparedStatement findRequest(String nameRequest) {
        PreparedStatement request = null;
        try {
            request = this.connection.prepareStatement(this.sqlrequest.getProperty(nameRequest));
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }

        return request;
    }

    /**
     * Метод add  добавление заявок в трекер.
     *
     * @param item - объект item.
     * @return возвращаем item.
     */
    public void add(Item item) {
        try (PreparedStatement ps = findRequest("add.item")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * Метод delete  удаляет объект из массива и обрезает его.
     *
     * @param item - объект item.
     */

    public void delete(Item item) {
        try(PreparedStatement ps = findRequest("delete.item")) {
            if (item != null) {
                ps.setInt(1, Integer.parseInt(item.getId()));
                ps.execute();
            } else {
                System.out.println("Task not found by this ID.");
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    /**
     * Метод update  обновляет объект из массива.
     *
     * @param item - объект item.
     */
    public void update(Item item) {
        try (PreparedStatement ps = findRequest("edit.item")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setInt(3, Integer.parseInt(item.getId()));
            ps.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        } catch (Exception e) {
            Log.error(e.getMessage(), e);
        }
        /*for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                this.items[index] = item;
                break;
            }
        }*/
    }

    /**
     * Метод findByName  ищет заявку по имени.
     *
     * @param name - название.
     * @return возвращаем обрезанный архив result.
     */
    public List<Item> findByName(String name) {
        List<Item> findItems = new LinkedList<>();
        try (PreparedStatement ps = findRequest("find.item.name")) {
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                if (!result.getString("name").equals(null)) {
                    findItems.add(initItem(result));
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return findItems;
    }

    /**
     * Метод findById ищем заявку по ID.
     *
     * @param id передаем ID заявки.
     * @return возвращаем item - найденную заявку.
     */
    protected Item findById(String id) {
        Item item = null;
        try (PreparedStatement ps = findRequest("find.item.id")) {
            ps.setInt(1, Integer.parseInt(id));
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                if (!result.getString("id").equals(null)) {
                    item = initItem(result);
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return item;
    }

    /**
     * Метод getAll возвращаем копию массива без null.
     *
     * @return возвращаем result.
     */
    public List<Item> getAll() {
        List<Item> allItems = new LinkedList<>();
        try (PreparedStatement ps = findRequest("find.item.all")) {
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                if (!result.getString("name").equals(null)) {
                    allItems.add(initItem(result));
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return allItems;
    }
    /**
     * Метод initItem создаем объект Item.
     * @param result данные из SQL запроса.
     * @return возвращаем обхект Item.
     */
    private Item initItem(ResultSet result) {
        Item item = null;
        try {
            item = new Item(result.getString("id"),
                    result.getString("name"),
                    result.getString("description"),
                    result.getTimestamp("create_date"));
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            connection.close();
        }
    }
}
