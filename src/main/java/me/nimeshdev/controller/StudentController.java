package me.nimeshdev.controller;

import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;
import me.nimeshdev.service.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    public int handleAddStudent(Student student) throws Exception {
        // remove empty spaces
        student.setFirstName(student.getFirstName().trim());
        student.setLastName(student.getLastName().trim());
        student.getContact().setPhoneNumber(student.getContact().getPhoneNumber().trim());
        student.getContact().setEmail(student.getContact().getEmail().trim().toLowerCase());

        if(student.getFirstName() == null || student.getLastName() == null)
            throw new StudentDataValidationException("student name can't be null");
        else if(student.getFirstName().isBlank() || student.getLastName().isBlank())
            throw new StudentDataValidationException("student name can't be blank");
        else if(student.getContact().getEmail() == null || student.getContact().getPhoneNumber() == null)
            throw new StudentDataValidationException("student contact can't be null");

        return studentService.addStudent(student);
    }
}
