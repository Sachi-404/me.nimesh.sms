package me.nimeshdev.dao;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.model.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CourseDAO {

    public int add(Course course) throws Exception {

        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();

            return course.getCourseId();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}
