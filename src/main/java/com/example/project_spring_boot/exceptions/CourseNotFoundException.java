package com.example.project_spring_boot.exceptions;

import java.text.MessageFormat;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
    }

    public CourseNotFoundException(Long id) {
        super(MessageFormat.format("Could not find course with id: {0}", id));
    }
}
