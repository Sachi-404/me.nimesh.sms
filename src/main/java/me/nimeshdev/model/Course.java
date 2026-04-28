package me.nimeshdev.model;

import jakarta.persistence.*;
import me.nimeshdev.dto.CourseDTO;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CourseId;
    private String name;
    private String code;
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    List<Student> students;

    public Course() {}

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Course(int CourseId, String name, String code) {
        this.CourseId = CourseId;
        this.name = name;
        this.code = code;
    }

    public CourseDTO transfer() {
        return new CourseDTO(getCourseId(), getName(), getCode());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int CourseId) {
        this.CourseId = CourseId;
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
        return STR."Subject{subjectId=\{CourseId}, name='\{name}\{'\''}, code='\{code}\{'\''}\{'}'}";
    }
}
