package ru.job4j.servlets;

import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.User;
import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
        session.setAttribute("user", logic.findByLogin((String) session.getAttribute("login")));
        request.setAttribute("users", logic.findAll());
        request.getRequestDispatcher("/WEB-INF/views/ListUsers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        if (request.getParameter("action").equals("exit")) {
            session.invalidate();
        }
        if (request.getParameter("action").equals("add")) {
            if (checkUser(request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("city"),
                    request.getParameter("country"),
                    request.getParameter("password"),
                    request.getParameter("email"))) {
                logic.add(new User(
                        request.getParameter("name"),
                        request.getParameter("login"),
                        request.getParameter("city"),
                        request.getParameter("country"),
                        request.getParameter("password"),
                        request.getParameter("email"),
                        new GregorianCalendar()));
            } else {
                    request.setAttribute("error", "Invalid user data.");
            }
        } else if (request.getParameter("action").equals("update")) {
            if (checkUser(request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("city"),
                    request.getParameter("country"),
                    request.getParameter("password"),
                    request.getParameter("email"))) {
                logic.update(new User(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("login"),
                        request.getParameter("city"),
                        request.getParameter("country"),
                        request.getParameter("password"),
                        request.getParameter("email"),
                        new GregorianCalendar(),
                        new Role(Integer.parseInt(request.getParameter("roles_id")), "NewRole")));
            } else {
                request.setAttribute("error", "Invalid user data.");
            }
        } else if (request.getParameter("action").equals("delete")) {
            logic.delete(Integer.parseInt(request.getParameter("id")));
        }
        response.sendRedirect(String.format("%s/", request.getContextPath()));
    }

    private boolean checkUser(String name, String login, String city, String country, String password, String email) {
        boolean result = true;
        if (name.equals("")
                || login.equals("")
                || city.equals("")
                || country.equals("")
                || password.equals("")
                || email.equals("")) {
            result = false;
        }
        return result;
    }
}
