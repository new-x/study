package ru.job4j.servlets;

import ru.job4j.servlets.data.User;
import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 27.07.2018 16:08
 */

public class UserUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = ValidateService.getInstance().getUser(Integer.parseInt(request.getParameter("id")));
        if (user != null) {
            request.getSession().setAttribute("allRoles", ValidateService.getInstance().getRoles());
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/views/EditUser.jsp").forward(request, response);
        }
    }
}
