package ru.job4j.servlets;

import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 23.07.2018 16:54
 */

public class UserServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("" + logic.findAll());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if (request.getParameter("action").equals("add")) {
            if (logic.checkInt(request.getParameter("id"))) {
                logic.add(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("login"),
                        request.getParameter("email"));
            }
        } else if (request.getParameter("action").equals("update")) {
            if (logic.checkInt(request.getParameter("id"))) {
                logic.update(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("login"),
                        request.getParameter("email"));
            }
        } else if (request.getParameter("action").equals("delete")) {
            if (logic.checkInt(request.getParameter("id"))) {
                logic.delete(Integer.parseInt(request.getParameter("id")));
            }
        }
        doGet(request, response);
    }
}
