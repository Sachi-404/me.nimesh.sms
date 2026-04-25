package me.nimeshdev.service;

import me.nimeshdev.dao.StudentDAO;
import me.nimeshdev.exception.StudentDataMergeException;
import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;

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
}
