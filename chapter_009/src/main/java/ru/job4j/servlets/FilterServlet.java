package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.Brand;
import ru.job4j.car.models.Filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FilterServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(PlatformServlet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    private final Logic logic = new Logic();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        Filter filter = CONVERTER.readValue(request.getReader(), Filter.class);
        if(filter.getBrand().getId() == 0) {
            filter.setBrand(null);
        }
        CONVERTER.writeValue(writer, logic.getAllAdsByFilter(filter));
        writer.flush();
    }
}
