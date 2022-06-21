package com.example.project_spring_boot.exceptions;

import org.aspectj.bridge.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CompanyIsAlreadyAssignedException extends RuntimeException {
    public CompanyIsAlreadyAssignedException(Long companyId) {
        super(MessageFormat.format("Company: {0} id already assigned to courses ", companyId));
    }
}
