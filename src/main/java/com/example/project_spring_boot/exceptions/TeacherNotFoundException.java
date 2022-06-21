package com.example.project_spring_boot.exceptions;

import java.text.MessageFormat;

public class TeacherNotFoundException extends RuntimeException {
    public TeacherNotFoundException(Long id) {
        super(MessageFormat.format("Could not find teacher with id: {0}", id));
    }
}
