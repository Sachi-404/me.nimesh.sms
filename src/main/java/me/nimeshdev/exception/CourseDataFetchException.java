package me.nimeshdev.exception;

public class CourseDataFetchException extends Exception{

    public CourseDataFetchException(String msg, Exception e) {
        super(msg, e);
    }
}
