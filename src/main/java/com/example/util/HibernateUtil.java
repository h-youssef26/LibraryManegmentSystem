package com.example.util;  // Must match the package!

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure("hibernate.cfg.xml")  // Loads from src/main/resources
                        .build();

                Metadata metadata = new MetadataSources(registry)
                        .addAnnotatedClass(User.class)  // Link to your entity
                        .getMetadataBuilder()
                        .build();

                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }



    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    public static Session openSession() {
        Session session;
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory()) {
            session = sessionFactory.openSession();
        }
        return session;
    }
}