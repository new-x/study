package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.Ad;
import ru.job4j.car.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(AddServlet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    private final Logic logic = new Logic(new TransactionWrapper());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        Ad ad = CONVERTER.readValue(request.getReader(), Ad.class);
        if (request.getSession().getAttribute("login") != null && ad != null) {
            User user = new User((String) request.getSession().getAttribute("login"));
            if (logic.checkAdByUser(ad, user)){
                ad = logic.getAddById(ad);
                ad.setDone(true);
                logic.addOrUpdateAd(ad);
            }
        }
        writer.flush();
    }
}
