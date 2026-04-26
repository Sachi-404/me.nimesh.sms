package me.nimeshdev.exception;

public class StudentDataFetchException extends Exception {

    public StudentDataFetchException(String msg, Exception e) {

        super(msg, e);
    }
}
