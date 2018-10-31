package ru.job4j.storage;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.job4j.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Properties;

@Component("jdbcStorage")
public class JbdcStorage implements Storage {
    private final Logger Log = LoggerFactory.getLogger(JbdcStorage.class);
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final Properties CONFIG = new Properties();

    @Autowired
    public JbdcStorage() {
        try (InputStream config = JbdcStorage.class.getClassLoader().getResourceAsStream("config.properties")) {
            CONFIG.load(config);
        } catch (IOException e) {
            Log.error(e.getMessage());
        }
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl(CONFIG.getProperty("db.url"));
        SOURCE.setUsername(CONFIG.getProperty("db.user"));
        SOURCE.setPassword(CONFIG.getProperty("db.password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement = connection.prepareStatement("insert into users (name) values (?)")) {
            statement.setString(1, user.getName());
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public User get(int id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from users where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("id") == id) {
                        user = new User(resultSet.getString("name"));
                    }
                }
            }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
        return user;
    }
}
