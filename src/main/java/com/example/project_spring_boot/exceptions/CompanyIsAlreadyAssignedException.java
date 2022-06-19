package com.example.project_spring_boot.exceptions;

import org.aspectj.bridge.Message;

import java.text.MessageFormat;

public class CompanyIsAlreadyAssignedException extends RuntimeException {
    public CompanyIsAlreadyAssignedException(Long companyId) {
        super(MessageFormat.format("Company: {0} id already assigned to courses ", companyId));
    }
}
