package ru.job4j.servlets;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import ru.job4j.servlets.data.DBStore;
import ru.job4j.servlets.data.Role;
import ru.job4j.servlets.data.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets
 * Create data: 07.08.2018 14:00
 */

public class SigninControllerTest {
    private DBStore store = DBStore.getInstance();
    @Ignore
    @Test
    public void testSignInSessionByLogin() throws ServletException, IOException {
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpSession session = mock(HttpSession.class);
        try {

            User user = new User(1,"Maxim", "maxim", "Moscow", "Russia", "maxim", "maxim@mail.ru", new GregorianCalendar(), new Role(1, "Administrator"));
            store.add(user);

            when(request.getParameter("login")).thenReturn("maxim");
            when(request.getParameter("password")).thenReturn("maxim");
            when(request.getSession()).thenReturn(session);

            new SigninController().doPost(request, response);
            verify(session).setAttribute("login", "maxim");

        } finally {
            store.delete(store.findByLogin("maxim").getId());
        }

    }
}
