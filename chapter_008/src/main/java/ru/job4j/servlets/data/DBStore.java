package ru.job4j.servlets.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final Logger Log = LoggerFactory.getLogger(DBStore.class);
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DBStore INSTANCE = new DBStore();
    private static final Properties CONFIG = new Properties();

    static {
        try(InputStream config = DBStore.class.getClassLoader().getResourceAsStream("resources.properties")) {
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
        try(Connection connection = SOURCE.getConnection();
        PreparedStatement statement = connection.prepareStatement(CONFIG.getProperty("db.sqlbase"))) {
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
    }

    private DBStore() {
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into users (username, login, city, country, password, email, create_date, roles_id) values (?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getCity());
            statement.setString(4, user.getCountry());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setTimestamp(7, new Timestamp(user.getCreateDate().getTimeInMillis()));
            statement.setInt(8, 2);
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
    }

    @Override
    public void update(User user) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("update users set username=?, login=?, city=?, country=?, password=?, email=?, roles_id=? where id=?")) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getCity());
            statement.setString(4, user.getCountry());
            statement.setString(5, user.getPassword());
            statement.setString(6, user.getEmail());
            statement.setInt(7, user.getRole().getId());
            statement.setInt(8, user.getId());
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from users where id = ?")) {
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList();
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("select u.*, r.rolename from users as u left outer join roles as r on u.roles_id = r.id")) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(resultSet.getTimestamp("create_date").getTime());
                    allUsers.add(new User(resultSet.getInt("id"),
                            resultSet.getString("username"),
                            resultSet.getString("login"),
                            resultSet.getString("city"),
                            resultSet.getString("country"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            calendar,
                            new Role(resultSet.getInt("roles_id"), resultSet.getString("rolename"))));
                }
            } catch (SQLException e) {
                Log.error(e.getMessage());
            }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
        return allUsers;
    }

    @Override
    public User findById(int id) {
        User user = null;
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("select u.*, r.rolename from users as u left outer join roles as r on u.roles_id = r.id where u.id = ?")) {
            statement.setInt(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getInt("id") == id) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(resultSet.getTimestamp("create_date").getTime());
                        user = new User(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("login"),
                                resultSet.getString("city"),
                                resultSet.getString("country"),
                                resultSet.getString("password"),
                                resultSet.getString("email"),
                                calendar,
                                new Role(resultSet.getInt("roles_id"), resultSet.getString("rolename")));
                    }
                }
            }catch (SQLException e) {
                Log.error(e.getMessage());
            }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        try(Connection connection = SOURCE.getConnection();
            PreparedStatement statement = connection.prepareStatement("select u.*, r.rolename from users as u left outer join roles as r on u.roles_id = r.id where u.login = ?")) {
            statement.setString(1, login);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    if (resultSet.getString("login").equals(login)) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(resultSet.getTimestamp("create_date").getTime());
                        user = new User(resultSet.getInt("id"),
                                resultSet.getString("username"),
                                resultSet.getString("login"),
                                resultSet.getString("password"),
                                resultSet.getString("email"),
                                calendar,
                                new Role(resultSet.getInt("roles_id"), resultSet.getString("rolename")));
                    }
                }
            }catch (SQLException e) {
                Log.error(e.getMessage());
            }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> allUsers = new ArrayList<>();
        try(Connection connection = SOURCE.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from roles")) {
           try(ResultSet resultSet = statement.executeQuery()) {
               while (resultSet.next()) {
                   allUsers.add(new Role(resultSet.getInt("id"),
                           resultSet.getString("rolename")));
               }
           } catch (SQLException e) {
               Log.error(e.getMessage());
           }
        } catch (SQLException e) {
            Log.error(e.getMessage());
        }
        return allUsers;
    }
}
