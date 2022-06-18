package com.example.project_spring_boot.exceptions;

public class GroupNotfoundException extends RuntimeException{
    public GroupNotfoundException() {
    }

    public GroupNotfoundException(String message) {
        super(message);
    }
}
