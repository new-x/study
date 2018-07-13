package ru.job4j.magnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.magnit
 * Create data: 07.07.2018 20:52
 */

public class ParserMagnit {
    private Properties config;
    private Properties sqlrequest;
    private Connection connection;
    public static final String IN_FILE = "./chapter_005/src/main/resources/file.xml";
    public static final StoreXML storeXML = new StoreXML();
    private static final Logger Log = LoggerFactory.getLogger(ParserMagnit.class);


    private void initDB() {
        InputStream path = getClass().getClassLoader().getResourceAsStream("config.properties");
        InputStream sql = getClass().getClassLoader().getResourceAsStream("sqlrequest.properties");
        this.config = new Properties();
        this.sqlrequest = new Properties();
        try {
            this.config.load(path);
            this.sqlrequest.load(sql);
            this.connection = DriverManager.getConnection(this.config.getProperty("url.db"));
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

    private void clearEntry() {
            try(PreparedStatement ps = findRequest("clear.table")) {
                ps.execute();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
    }

    private void addField() {
        clearEntry();
        for (int index = 0; index < 10; index++) {
            try(PreparedStatement ps = findRequest("add.field")) {
                ps.setInt(1, index + 1);
                ps.execute();
            } catch (SQLException e) {
                Log.error(e.getMessage(), e);
            }
        }
    }

    private void selectAll() {
        try(PreparedStatement ps = findRequest("select.all")) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Entry.Field field = new Entry.Field();
                field.setValue(resultSet.getInt("field"));
                storeXML.save(field);
            }
        } catch (SQLException e) {
            Log.error(e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws Exception {
        ParserMagnit parserMagnit = new ParserMagnit();
        ConvertXSQT convertXSQT = new ConvertXSQT();
        parserMagnit.initDB();
        parserMagnit.addField();
        parserMagnit.selectAll();
        storeXML.expotToXML();
        convertXSQT.convertToXSLT();
    }

}
