package ru.job4j.servlets;

import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.User;

import static org.junit.Assert.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 06.08.2018 19:54
 */

public class UsersControllerTest extends Mockito {

    private DBStore store = DBStore.getInstance();


    @Test
    public void testUserControllerAddUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("name")).thenReturn("Petr");
        when(request.getParameter("login")).thenReturn("petr");
        when(request.getParameter("password")).thenReturn("petr");
        when(request.getParameter("email")).thenReturn("petr@mail.ru");
        new UsersController().doPost(request, response);
        assertTrue(store.findByLogin("petr").getLogin().equals("petr"));
        store.delete(store.findByLogin("petr").getId());
    }

    @Test
    public void testUserControllerUpdateUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        User user = new User(1,"Maxim", "maxim", "maxim", "maxim@mail.ru", new GregorianCalendar(), new Role(1, "Administrator"));
        store.add(user);
        when(request.getParameter("action")).thenReturn("update");
        when(request.getParameter("id")).thenReturn(String.valueOf(store.findByLogin("maxim").getId()));
        when(request.getParameter("name")).thenReturn("Kirill");
        when(request.getParameter("login")).thenReturn("kirill");
        when(request.getParameter("password")).thenReturn("kirill");
        when(request.getParameter("email")).thenReturn("kirill@mail.ru");
        when(request.getParameter("roles_id")).thenReturn("1");
        new UsersController().doPost(request, response);
        assertTrue(store.findByLogin("kirill").getLogin().equals("kirill"));
        store.delete(store.findByLogin("kirill").getId());
    }

    @Test
    public void testUserControllerDeleteUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        User user = new User(1,"Kirill", "kirill", "kirill", "mail@mail.ru", new GregorianCalendar(), new Role(1, "Administrator"));
        store.add(user);
        when(request.getParameter("action")).thenReturn("delete");
        when(request.getParameter("id")).thenReturn(String.valueOf(store.findByLogin("kirill").getId()));
        new UsersController().doPost(request, response);
        assertNull(store.findByLogin("kirill"));
    }
}
