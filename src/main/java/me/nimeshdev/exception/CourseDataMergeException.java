package me.nimeshdev.exception;

public class CourseDataMergeException extends Exception {

    public CourseDataMergeException(String msg, Exception e) {
        super(msg, e);
    }
}
