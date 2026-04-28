package me.nimeshdev.exception;

public class CourseDataValidationException extends Exception {

    public CourseDataValidationException(String msg, Exception e) {
        super(msg, e);
    }
}
