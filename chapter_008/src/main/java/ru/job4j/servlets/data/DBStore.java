package ru.job4j.servlets.data;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.data
 * Create data: 31.07.2018 16:33
 */

public class DBStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();
    private static final Properties CONFIG = new Properties();

    static {
        try(InputStream config = DBStore.class.getClassLoader().getResourceAsStream("resources.properties")) {
            CONFIG.load(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl(CONFIG.getProperty("db.url"));
        SOURCE.setUsername(CONFIG.getProperty("db.user"));
        SOURCE.setPassword(CONFIG.getProperty("db.password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    private DBStore() {
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into users (name, login, email, create_date) values (?, ?, ?, ?)")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setTimestamp(4, new Timestamp(user.getCreateDate().getTimeInMillis()));
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("update users set name=?, login=?, email=? where id=?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from users where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList();
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from users")) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(resultSet.getTimestamp("create_date").getTime());
                    users.add(new User(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("login"),
                            resultSet.getString("email"),
                            calendar));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from users where id = ?")) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("id") == id) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(resultSet.getTimestamp("create_date").getTime());
                        user = new User(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("login"),
                                resultSet.getString("email"),
                                calendar);
                    }
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
