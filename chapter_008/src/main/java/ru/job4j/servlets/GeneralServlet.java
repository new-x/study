package ru.job4j.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GeneralServlet extends HttpServlet {
    private ConcurrentHashMap<Integer, JsonUser> users = new ConcurrentHashMap();
    private AtomicInteger counter = new AtomicInteger(0);
    private final ObjectMapper CONVERTER = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        CONVERTER.writeValue(writer, users.values());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        BufferedReader reader = request.getReader();
        JsonUser user = new ObjectMapper().readValue(reader.readLine(), JsonUser.class);
        users.putIfAbsent(counter.getAndIncrement(), user);
        PrintWriter writer = response.getWriter();
        writer.flush();

    }

    public static class JsonUser {
        private String name;
        private String surname;
        private String gender;

        public JsonUser(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    }
}
