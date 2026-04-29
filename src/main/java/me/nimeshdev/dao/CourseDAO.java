package me.nimeshdev.dao;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.model.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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

    public List<CourseDTO> all() throws RuntimeException {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Course> query = session.createQuery("FROM Course", me.nimeshdev.model.Course.class);

            // transfer data into DTO
            return query.stream().map(
                    course -> new CourseDTO(
                            course.getCourseId(), course.getName(), course.getCode()
                    )
            ).toList();
        }
    }

    public List<CourseDTO> allCoursesThatStudentNotRegisterYet(int studentId) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery(
                    """
                            SELECT c FROM Course c
                            WHERE c NOT IN (
                                SELECT cs FROM Student s
                                JOIN s.courses cs
                                WHERE s.studentId = :studentId
                            )"""
                    , me.nimeshdev.model.Course.class
                ).setParameter("studentId", studentId).stream().map(Course::transfer).toList();

        } catch (Exception e) {
            throw e;
        }
    }
}
