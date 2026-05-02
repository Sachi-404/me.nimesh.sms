package me.nimeshdev.service;

import me.nimeshdev.dao.CourseDAO;
import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.exception.CourseDataValidationException;
import me.nimeshdev.model.Course;

import java.util.List;

public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService() {
        this.courseDAO = new CourseDAO();
    }

    public int addCourse(CourseDTO courseDTO) throws Exception {

        if (courseDTO.getCode().length() != 7)
            throw new CourseDataValidationException("invalid course code length", null);

        return courseDAO.add(new Course(
                courseDTO.getName()
                , courseDTO.getCode()
        ));
    }

    public List<CourseDTO> getAllCourses() throws Exception {

        return courseDAO.all();
    }

    public List<CourseDTO> allCoursesThatStudentNotRegisterYet(int studentId) throws Exception {

        return courseDAO.allCoursesThatStudentNotRegisterYet(studentId);
    }
}
