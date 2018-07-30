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
 * Create data: 27.07.2018 16:08
 */

public class UserCreateServlet extends HttpServlet {
    private final ValidateService logic = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append(createUser(request.getContextPath(), ""));
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        if (request.getParameter("name") != null &&
                request.getParameter("login") != null &&
                request.getParameter("email") != null) {
            logic.add(request.getParameter("name"),
                    request.getParameter("login"),
                    request.getParameter("email"));
            writer.append(createUser(request.getContextPath(),
                    "<b>User added.</b>" +
                            "<form action='" + request.getContextPath() + "/list'method='GET'>" +
                            "<input type='submit' value='See all Users'/>" +
                            "</form>"));
        } else {
            writer.append(createUser(request.getContextPath(), "<b>The data entered is incorrect, please try again.</b>"));
        }
        writer.flush();
    }

    public String createUser(String contextPath, String message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>Create User</title>" +
                message +
                "<form action='" + contextPath + "/create'method='POST'>" +
                "Name : <input type='text' name='name'/><br>" +
                "Login : <input type='text' name='login'/><br>" +
                "Email : <input type='text' name='email'/><br>" +
                "<input type='submit' value='Create User'/>" +
                "</form>" +
                "</head>" +
                "<body>" +
                "</body>" +
                "</html>");
        return sb.toString();
    }
}
