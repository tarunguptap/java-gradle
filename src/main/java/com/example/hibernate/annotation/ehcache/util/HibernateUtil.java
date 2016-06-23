package com.example.hibernate.annotation.ehcache.util;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            // return new AnnotationConfiguration().configure(new File(System.getProperty("user.dir") +
            // "/src/CacheImplementation/comcache/cfg/hibernate.cfg.xml")).buildSessionFactory();
            ApplicationContext context = new ClassPathXmlApplicationContext(
                    "com/example/hibernate/annotation/ehcache/cfg/applicationContext.xml");
            SessionFactory sessFactory = (SessionFactory) context.getBean("sessionFactory");
            return sessFactory;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
