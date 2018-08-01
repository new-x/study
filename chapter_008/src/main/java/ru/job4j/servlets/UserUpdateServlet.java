package ru.job4j.servlets;

import ru.job4j.servlets.data.User;
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
 * Create data: 27.07.2018 16:08
 */

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();
    private volatile int id;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        if (request.getParameter("id") != null) {
            this.id = Integer.parseInt(request.getParameter("id"));
            writer.append(getUser(request.getContextPath(), ""));
        }
        writer.flush();


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        String message;
        if (request.getParameter("name") != null &&
                request.getParameter("login") != null &&
                request.getParameter("email") !=null) {
            logic.update(new User(request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("email")));
            message = "<b>User update.</b>" +
                    "<form action='" + request.getContextPath() + "/list'method='GET'>" +
                    "<input type='submit' value='See all Users'/>" +
                    "</form>";
            writer.append(getUser(request.getContextPath(), message));
        }
        writer.flush();

    }

    private String getUser(String contextPath,String message) {
        User user = null;
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Edit User</title>" +
                message);
        if (logic.getUser(this.id) != null) {
            user = logic.getUser(this.id);
            sb.append(
                    "<form action='" + contextPath + "/edit'method='POST'>" +
                    "New Name : <input type='text' name='name'value='" + user.getName() + "'/><br>" +
                    "New Login : <input type='text' name='login'value='" + user.getLogin() + "'/><br>" +
                    "New Email : <input type='text' name='email' value='" + user.getEmail() + "'/><br>" +
                    "<input type='submit' value='Edit User'/>" +
                    "</form>");
        }
        sb.append("</head>" +
                "<body>" +
                "</body>" +
                "</html>");


        return sb.toString();
    }
}
