package com.example.project_spring_boot.exceptions;

import java.text.MessageFormat;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Long id) {
        super(MessageFormat.format("Could not find student with id: {0}", id));
    }
}
