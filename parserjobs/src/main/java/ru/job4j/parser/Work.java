package ru.job4j.parser;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.parser
 * Create data: 11.07.2018 23:31
 */

public class Work implements AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(Work.class);
    private final Properties request = new Properties();
    private Properties config = new Properties();;
    private Connection connection;
    private Data data;

    public void initCon(String path) {
        try {
            this.config.load(getClass().getClassLoader().getResourceAsStream(path));
            this.request.load(getClass().getClassLoader().getResourceAsStream("request.properties"));

        } catch (IOException e) {
            LOGGER.error(e);
        }
        try {
            this.connection = DriverManager.getConnection(
                    this.config.getProperty("jdbc.url"),
                    this.config.getProperty("jdbc.user"),
                    this.config.getProperty("jdbc.password"));
            try (PreparedStatement ps = findRequest("create.table")) {
                ps.execute();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        String startDate = this.config.getProperty("start.date");
        int[] startDates = Arrays.stream(startDate.split(" ")).mapToInt(Integer::parseInt).toArray();
        this.data = new Data(startDates[0],
                             startDates[1],
                             startDates[2],
                             startDates[3],
                             startDates[4],
                             startDates[5],
                             setDate());
    }

    public PreparedStatement findRequest(String nameRequest) {
        PreparedStatement request = null;
        try {
            request = this.connection.prepareStatement(this.request.getProperty(nameRequest));
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return request;
    }

    public void request(Job job) {
        try (PreparedStatement ps = findRequest("add.job")) {
            ps.setString(1, job.getThread());
            ps.setString(2, job.getUrl());
            ps.setTimestamp(3, new Timestamp(job.getCreat_date().getTimeInMillis()));
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public boolean checker(String name, String url, String date) {
        boolean result = this.data.checkDate(this.data.parsingDate(date));
        if (result) {
            request(new Job(name, url, this.data.parsingDate(date)));
            LOGGER.info("Добавление вакансии в базу. " + name);
        }
        return result;
    }

    public Calendar setDate() {
        Calendar lastDate = new GregorianCalendar();
        try (PreparedStatement ps = findRequest("get.date")) {
            ResultSet result = ps.executeQuery();
                while (result.next()) {
                    if (result.getTimestamp("min") != null) {
                        lastDate = new GregorianCalendar();
                        lastDate.setTimeInMillis((result.getTimestamp("min").getTime()));
                        LOGGER.info("Дата последний темы: " + lastDate.getTime());
                    } else if (result.getTimestamp("min") == null) {
                        lastDate = null;
                        LOGGER.error("Дата последний темы не найдена.");
                    }
                }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return lastDate;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
