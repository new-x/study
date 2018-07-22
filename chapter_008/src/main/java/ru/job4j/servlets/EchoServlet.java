package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 21.07.2018 20:48
 */

public class EchoServlet extends HttpServlet {
    private static final Logger Log = LoggerFactory.getLogger(EchoServlet.class);

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("hello world");
        writer.flush();
    }
}
