package me.nimeshdev.controller;

import me.nimeshdev.dto.StudentDTO;
import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;
import me.nimeshdev.service.StudentService;

import java.util.List;

public class StudentController {

    private final StudentService studentService;

    public StudentController() {
        this.studentService = new StudentService();
    }

    public int handleAddStudent(Student student) throws Exception {
        validateObject(student); // validate student Object

        return studentService.addStudent(student);
    }

    public List<Student> handleAllStudent() throws Exception {

        return studentService.getAllStudent();
    }

    public Student handleStudentById(int id) throws Exception {

        if (id < -1) throw new StudentDataValidationException("invalid student id to fetch student record by id");

        return studentService.getStudentById(id);
    }

    public int handleStudentUpdate(Student student) throws Exception {
        validateObject(student);

        return studentService.updateStudent(student);
    }

    public StudentDTO handleStudentWithAllCourses(int id) throws Exception {

        return studentService.getStudentWithAllCourses(id);
    }

    public void enrollCourse(int studentId, int courseId) throws Exception {

        studentService.enrollCourse(studentId, courseId);
    }

    private void validateObject(Student student) throws Exception {
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

    }

}
