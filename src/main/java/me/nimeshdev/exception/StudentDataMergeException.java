package me.nimeshdev.exception;

public class StudentDataMergeException extends Exception {

    public StudentDataMergeException(String msg, Exception e) {
        super(msg, e);
    }
}
