package me.nimeshdev.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public HibernateUtil() {
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {

        try {
                return new Configuration()
                        .addAnnotatedClass(me.nimeshdev.model.User.class)
                        .addAnnotatedClass(me.nimeshdev.model.Student.class)
                        .addAnnotatedClass(me.nimeshdev.model.Subject.class)
                        .configure()
                        .buildSessionFactory();

        } catch (Exception e) {
            throw new RuntimeException("Hibernate SessionFactory creation fail! :", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
