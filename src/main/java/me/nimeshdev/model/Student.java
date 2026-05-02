package me.nimeshdev.model;

import jakarta.persistence.*;
import me.nimeshdev.dto.StudentDTO;
import me.nimeshdev.model.embedded.StudentContact;

import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String firstName;
    private String lastName;
    @Embedded
    private StudentContact contact;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Course> courses;

    public Student() {}

    public Student(String firstName, String lastName, StudentContact contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public Student(int studentId, String firstName, String lastName, StudentContact contact) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
    }

    public Student(int studentId, String firstName, String lastName, StudentContact contact, List<Course> courses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.courses = courses;
    }

    public StudentDTO transfer() {
        return new StudentDTO(
                getStudentId()
                , getFirstName()
                , getLastName()
                , getContact());
    }

    public StudentDTO transferAll() {
        return new StudentDTO(
                getStudentId()
                , getFirstName()
                , getLastName()
                , getContact()
                , getCourses().stream().map(Course::transfer).toList());
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
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
