package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.models.Item;
import ru.job4j.work.Work;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class GeneralServelet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(GeneralServelet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Work  work = new Work();
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        CONVERTER.writeValue(writer, work.getAllItems());
        LOGGER.info("Данные будут отправлены.");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Work  work = new Work();
        response.setContentType("application/json");
        Item item = CONVERTER.readValue(request.getReader(), Item.class);
        item.setCreatdata(new Timestamp(System.currentTimeMillis()));
        LOGGER.info("Item desck - " + item.getDescription());
        work.addItem(item);
        PrintWriter writer = response.getWriter();
        writer.flush();
    }
}
