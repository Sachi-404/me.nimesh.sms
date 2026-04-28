package me.nimeshdev.dto;

import jakarta.persistence.*;
import me.nimeshdev.model.Course;
import me.nimeshdev.model.embedded.StudentContact;

import java.util.List;

public class StudentDTO {

    private int studentId;
    private String firstName;
    private String lastName;
    private StudentContact contact;
    private List<CourseDTO> courses;

    public StudentDTO() {}

    public StudentDTO(String firstName, String lastName, StudentContact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public StudentDTO(int studentId, String firstName, String lastName, StudentContact contact) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public StudentDTO(int studentId, String firstName, String lastName, StudentContact contact, List<CourseDTO> courses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.courses = courses;
    }

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudentContact getContact() {
        return contact;
    }

    public void setContact(StudentContact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return STR."Student{studentId=\{studentId}, firstName='\{firstName}\{'\''}, lastName='\{lastName}\{'\''}, contact=\{contact}\{'}'}";
    }
}

