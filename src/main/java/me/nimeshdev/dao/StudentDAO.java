package me.nimeshdev.dao;

import me.nimeshdev.config.HibernateUtil;
import me.nimeshdev.exception.StudentDataFetchException;
import me.nimeshdev.exception.StudentDataMergeException;
import me.nimeshdev.model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

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
            throw new StudentDataMergeException(STR."add() : fail to insert new student record : \{e.getMessage()}", e);
        }
    }

    public List<Student> all() throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            /**
             * TODO : with close with resources session object close auto maticly work fine BUT
             *  the every Student object has collection call Subject this "fetch as Lazy fetching.. "
             *  with hat if I request subject[] data rom Student it fetch later but the case is
             *      to do that this session need to be active.... ??????
             *      other wise it cont be fetch
             * */

            Query<Student> studentQuery = session.createQuery("FROM Student", me.nimeshdev.model.Student.class);

            return studentQuery.list();
        } catch (Exception e) {
            throw new StudentDataFetchException(STR."all() : fail to fetch all student record : \{e.getMessage()}", e);
        }
    }

    public Student get(int id) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.find(me.nimeshdev.model.Student.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    public int update(Student student) throws Exception {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            student = session.merge(student);
            transaction.commit();

            return student != null ? student.getStudentId() : -1;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}
