package ru.job4j.servlets;

import ru.job4j.servlets.data.User;
import ru.job4j.servlets.logic.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.logic
 * Create data: 27.07.2018 16:08
 */

public class UsersServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private ConcurrentHashMap<Integer, User> users;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        users = logic.findAll();
        writer.append(getAllUsers(request.getContextPath(), ""));
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userId = request.getParameter("id");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        if (userId != null) {
            if (logic.delete(Integer.parseInt(userId))) {
                writer.append(getAllUsers(request.getContextPath(), "User deleted."));
            } else {
                writer.append(getAllUsers(request.getContextPath(), "User not found."));
            }
        }
        writer.flush();
    }

    private String getAllUsers(String contextPath, String message) {
        StringBuilder sb = new StringBuilder();
        StringBuilder allUsers = new StringBuilder();
        for (Map.Entry entry : users.entrySet()) {
            User user = (User) entry.getValue();
            allUsers.append("<tr><td>" + user.getName() + "</td>" +
                    "<td>" + user.getLogin() + "</td>" +
                    "<td>" + user.getEmail() + "</td>" +
                    "<td>" + user.getCreateDate().getTime() + "</td>" +
                    "<td>" +
                    "<form action='" + contextPath + "/edit'method='GET'>" +
                    "<input type='hidden' name='id' value='" + user.getId() + "'/>" +
                    "<input type='submit' value='Edit'/>" +
                    "</form>" +
                    "</td>" +
                    "</form>" +
                    "<td>" +
                    "<form action='" + contextPath + "/list'method='POST'>" +
                    "<input type='hidden' name='id' value='" + user.getId() + "'/>" +
                    "<input type='submit' value='Delete'/>" +
                    "</form>" +
                    "</td>" +
                    "</tr>");
        }
        sb.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>All Users</title>" +
                "</head>" +
                "<body>" +
                "<b>" + message + "</b>" +
                "<form action='" + contextPath + "/create' method='GET'>" +
                "<input type='submit' value='Create User'/>" +
                "</form>" +
                "<table border = 1>" +
                "<tr>" +
                "<td>Name</td>" +
                "<td>Login</td>" +
                "<td>Email</td>" +
                "<td>Create date</td>" +
                "</tr>" +
                allUsers.toString() +
                "</table>" +
                "</body>" +
                "</html>");
        return sb.toString();
    }
}
