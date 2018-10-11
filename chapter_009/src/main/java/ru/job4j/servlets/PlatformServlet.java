package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.Ad;
import ru.job4j.car.models.Auth;
import ru.job4j.car.models.Filter;
import ru.job4j.car.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PlatformServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(PlatformServlet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    private final Logic logic = new Logic(new TransactionWrapper());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        if (request.getParameter("action") != null) {
            if (logic.getAll(request.getParameter("action")) != null) {
                CONVERTER.writeValue(writer, logic.getAll(request.getParameter("action")));
            }
        } else {
            CONVERTER.writeValue(writer, logic.getAllAds(new Filter()));
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        Ad ad = logic.getAddById(CONVERTER.readValue(request.getReader(), Ad.class));
        if (!ad.isDone()) {
            if (logic.checkAdByUser(ad, new User((String) request.getSession().getAttribute("login")))) {
                writer.append("true");
            }
        }
        writer.flush();
    }
}
