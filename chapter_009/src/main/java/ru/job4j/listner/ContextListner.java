package ru.job4j.listner;

import ru.job4j.data.Data;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListner implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Data.getINSTANCE().close();
    }
}
