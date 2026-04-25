package me.nimeshdev.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    private String name;
    private String code;
    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    List<Student> students;

    public Subject() {}

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return STR."Subject{subjectId=\{subjectId}, name='\{name}\{'\''}, code='\{code}\{'\''}\{'}'}";
    }
}
