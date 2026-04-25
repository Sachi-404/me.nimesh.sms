package me.nimeshdev.dao;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.exception.StudentDataMergeException;
import me.nimeshdev.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO {

    public int add(Student student) throws Exception {

        Transaction studentTransaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            studentTransaction = session.beginTransaction();
            session.persist(student);
            studentTransaction.commit();
            return student.getStudentId();
        } catch (Exception e) {
            if (studentTransaction != null) studentTransaction.rollback();
            throw new StudentDataMergeException(STR."fail to insert new student record : \{e.getMessage()}", e);
        }
    }
}
