package me.nimeshdev.service;

import me.nimeshdev.dao.StudentDAO;
import me.nimeshdev.exception.StudentDataFetchException;
import me.nimeshdev.exception.StudentDataMergeException;
import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    public int addStudent(Student student) throws Exception {

        if(!student.getContact().getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new StudentDataValidationException("email is invalid format");
        if(!student.getContact().getPhoneNumber().matches("\\d{10}"))
            throw new StudentDataValidationException("phone number is invalid format");

        try {
            return studentDAO.add(student);
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Student> getAllStudent() throws Exception {

        List<Student> students = studentDAO.all();

        if (students.isEmpty()) throw new StudentDataFetchException("no student records found", null);

        return students;
    }
}
