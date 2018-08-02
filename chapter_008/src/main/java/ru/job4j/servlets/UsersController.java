package ru.job4j.servlets;

import ru.job4j.servlets.data.User;
import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 23.07.2018 16:54
 */

public class UsersController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("users", ValidateService.getInstance().findAll());
            request.getRequestDispatcher("/WEB-INF/views/ListUsers.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if (request.getParameter("action").equals("add")) {
            logic.add(new User(
                    request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("email"),
                    new GregorianCalendar()));
        } else if (request.getParameter("action").equals("update")) {
            logic.update(new User(
                    Integer.parseInt(request.getParameter("id")),
                    request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("email"),
                    new GregorianCalendar()));
        } else if (request.getParameter("action").equals("delete")) {
            logic.delete(Integer.parseInt(request.getParameter("id")));
        }
        response.sendRedirect(String.format("%s/", request.getContextPath()));
    }
}
