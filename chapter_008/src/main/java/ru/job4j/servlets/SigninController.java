package ru.job4j.servlets;

import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 03.08.2018 19:35
 */

public class SigninController extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/views/LoginUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (logic.isCredentional(login, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("login", login);
                response.sendRedirect(String.format("%s/", request.getContextPath()));
        } else {
            request.setAttribute("error", "Credential invalid.");
            doGet(request, response);
        }
    }
}
