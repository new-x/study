package ru.job4j.data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Data {
    private static final SessionFactory SESSION_FACTORY;
    public static final Data INSTANCE = new Data();

    static {
        try {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            SESSION_FACTORY = metaData.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("Enitial SessionFactory creation failed" + e.getMessage());
            throw new ExceptionInInitializerError(e.getMessage());
        }
    }

    public static Data getINSTANCE() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public void close() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }

}
