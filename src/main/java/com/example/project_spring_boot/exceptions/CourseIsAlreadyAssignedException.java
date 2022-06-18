package com.example.project_spring_boot.exceptions;

import java.text.MessageFormat;

public class CourseIsAlreadyAssignedException extends RuntimeException{
    public CourseIsAlreadyAssignedException(final Long courseId, final Long companyId) {
        super(MessageFormat.format("Course: {0} is already assigned to company: {1}", courseId, companyId));
    }


}
