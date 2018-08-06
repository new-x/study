package ru.job4j.servlets.logic;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Alekseev Kirill.
 * Package name: ru.job4j.servlets.logic
 * Create data: 04.08.2018 16:35
 */

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        if (servletRequest.getRequestURI().contains("/signin")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = servletRequest.getSession();
            if (session.getAttribute("login") == null) {
                ((HttpServletResponse) response).sendRedirect(String.format("%s/signin", servletRequest.getContextPath()));
                return;
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
