package me.nimeshdev.dto;


import me.nimeshdev.model.Student;

import java.util.List;

public class CourseDTO {

    private int CourseId;
    private String name;
    private String code;
    List<Student> students;

    public CourseDTO() {}

    public CourseDTO(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public CourseDTO(int CourseId, String name, String code) {
        this.CourseId = CourseId;
        this.name = name;
        this.code = code;
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
