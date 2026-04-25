package me.nimeshdev.model;

import jakarta.persistence.*;
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
    private List<Subject> subjects;

    public Student() {}

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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
