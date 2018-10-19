package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.TransactionWrapper;
import ru.job4j.car.logic.Logic;
import ru.job4j.car.models.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(PlatformServlet.class);
    private final ObjectMapper CONVERTER = new ObjectMapper();
    private final Logic logic = new Logic();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        Auth outAuth = new Auth();
        if (session.getAttribute("login") != null) {
            outAuth.setLogin((String) session.getAttribute("login"));
        } else {
            outAuth.setMessage("Login not found.");
        }
        CONVERTER.writeValue(writer, outAuth);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        CONVERTER.writeValue(writer, logic.checkUserAuth(request.getSession(), CONVERTER.readValue(request.getReader(), Auth.class)));
        writer.flush();
    }


}
