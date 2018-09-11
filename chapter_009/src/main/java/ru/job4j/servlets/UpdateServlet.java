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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class UpdateServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(GeneralServelet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Work work = new Work();
        response.setContentType("application/json");
        Item item = CONVERTER.readValue(request.getReader(), Item.class);
        item = work.getItem(item);
        item.setDone(true);
        work.updateItem(item);
        PrintWriter writer = response.getWriter();
        writer.flush();
    }
}
