package me.nimeshdev.service;

import me.nimeshdev.dao.CourseDAO;
import me.nimeshdev.dao.StudentDAO;
import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.dto.StudentDTO;
import me.nimeshdev.exception.StudentDataFetchException;
import me.nimeshdev.exception.StudentDataMergeException;
import me.nimeshdev.exception.StudentDataValidationException;
import me.nimeshdev.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
        this.courseDAO = new CourseDAO();
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

    public Student getStudentById(int id) throws Exception {

        Student student =  studentDAO.get(id);

        if(student == null) throw new StudentDataFetchException("no student record found", null);

        return student;
    }

    public int updateStudent(Student student) throws  Exception{

        int effectId = studentDAO.update(student);

        if (effectId != student.getStudentId()) throw new StudentDataMergeException("fail to update student record", null);

        return effectId;
    }

    public StudentDTO getStudentWithAllCourses(int id) throws Exception {

        StudentDTO students = studentDAO.studentWithAllCourses(id);

        if (students == null) throw new StudentDataFetchException("no student records found", null);

        return students;
    }

    public void enrollCourse(int studentId, int courseId) throws Exception {

        StudentDTO studentDTO = studentDAO.studentWithAllCourses(studentId);
        CourseDTO courseDTO = courseDAO.get(courseId).transfer();

        ArrayList<CourseDTO> list = new ArrayList<>(studentDTO.getCourses());
        list.add(courseDTO);
        studentDTO.setCourses(list);

        studentDAO.update(studentDTO.transfer());

    }
}
