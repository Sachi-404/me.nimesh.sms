package me.nimeshdev.dao;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.model.User;
import org.hibernate.Session;

public class UserDAO {

    public User findUsername(String username) throws Exception {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM User WHERE username = ?1", me.nimeshdev.model.User.class)
                    .setParameter(1, username)
                    .uniqueResult();

        } catch (Exception e) {
            throw new RuntimeException(STR."findUserName() : \{e.getMessage()}");
        }
    }
}
