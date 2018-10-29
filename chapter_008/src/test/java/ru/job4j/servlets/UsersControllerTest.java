package ru.job4j.servlets;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j
 * Create data: 06.08.2018 19:54
 */

public class UsersControllerTest {

    private DBStore store = DBStore.getInstance();

    @Ignore
    @Test
    public void testUserControllerAddUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("action")).thenReturn("add");
        when(request.getParameter("name")).thenReturn("Petr");
        when(request.getParameter("login")).thenReturn("petr");
        when(request.getParameter("city")).thenReturn("Moscow");
        when(request.getParameter("country")).thenReturn("Russia");
        when(request.getParameter("password")).thenReturn("petr");
        when(request.getParameter("email")).thenReturn("petr@mail.ru");
        when(request.getParameter("roles_id")).thenReturn("1");
        new UsersController().doPost(request, response);
        assertTrue(store.findByLogin("petr").getLogin().equals("petr"));
        store.delete(store.findByLogin("petr").getId());
    }
    @Ignore
    @Test
    public void testUserControllerUpdateUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        User user = new User(1, "Maxim", "maxim", "Moscow", "Russia", "maxim", "maxim@mail.ru", new GregorianCalendar(), new Role(1, "Administrator"));
        store.add(user);
        when(request.getParameter("action")).thenReturn("update");
        when(request.getParameter("id")).thenReturn(String.valueOf(store.findByLogin("maxim").getId()));
        when(request.getParameter("name")).thenReturn("Kirill");
        when(request.getParameter("login")).thenReturn("kirill");
        when(request.getParameter("city")).thenReturn("Moscow");
        when(request.getParameter("country")).thenReturn("Russia");
        when(request.getParameter("password")).thenReturn("kirill");
        when(request.getParameter("email")).thenReturn("kirill@mail.ru");
        when(request.getParameter("roles_id")).thenReturn("1");
        new UsersController().doPost(request, response);
        assertTrue(store.findByLogin("kirill").getLogin().equals("kirill"));
        store.delete(store.findByLogin("kirill").getId());
    }
    @Ignore
    @Test
    public void testUserControllerDeleteUser() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        User user = new User(1, "Maxim", "maxim", "Moscow", "Russia", "maxim", "maxim@mail.ru", new GregorianCalendar(), new Role(1, "Administrator"));
        store.add(user);
        when(request.getParameter("action")).thenReturn("delete");
        when(request.getParameter("id")).thenReturn(String.valueOf(store.findByLogin("maxim").getId()));
        new UsersController().doPost(request, response);
        assertNull(store.findByLogin("maxim"));
    }
}
