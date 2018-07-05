package ru.job4j.tracker.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.tracker.start
 * Create data: 02.07.2018 23:27
 */

public class Connect implements AutoCloseable {
    private final String PATH_TO_CONFIG = "C:\\Storage\\Java\\study\\chapter_002\\src\\main\\java\\ru\\job4j\\tracker\\config\\config.properties";
    private FileInputStream path;
    private static final Logger Log = LoggerFactory.getLogger(Connect.class);
    protected Connection con;

    public Connect() {
        try {
            path = new FileInputStream(PATH_TO_CONFIG);
        } catch (FileNotFoundException e) {
            Log.error(e.getMessage(), e);
        }
        try {

            Properties config = new Properties();
            config.load(path);
            this.con = DriverManager.getConnection(
                    config.getProperty("db.host" ),
                    config.getProperty("db.user"),
                    config.getProperty("db.password"));
        } catch (IOException e) {
            Log.error(e.getMessage(), e);
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }

    }

    @Override
    public void close() throws Exception {

    }
}
