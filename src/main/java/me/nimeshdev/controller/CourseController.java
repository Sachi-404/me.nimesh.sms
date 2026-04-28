package me.nimeshdev.controller;

import me.nimeshdev.dto.CourseDTO;
import me.nimeshdev.exception.CourseDataValidationException;
import me.nimeshdev.service.CourseService;

public class CourseController {

    private final CourseService courseService;

    public CourseController() {
        this.courseService = new CourseService();
    }

    public int handleAddCourse(CourseDTO courseDTO) throws Exception {
        validateCourse(courseDTO);

        return courseService.addCourse(courseDTO);
    }

    private void validateCourse(CourseDTO courseDTO) throws Exception {
        if (courseDTO == null) throw new CourseDataValidationException("course dto can't be null", null);

        courseDTO.setName(courseDTO.getName().trim());
        courseDTO.setCode(courseDTO.getCode().trim());

        if (courseDTO.getCode() == null || courseDTO.getName() == null || courseDTO.getCode().isBlank() || courseDTO.getName().isBlank())
            throw new CourseDataValidationException("data fields can't be null or empty", null);
    }
}
