package com.example.project_spring_boot.exceptions;

import java.text.MessageFormat;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(Long id) {
        super(MessageFormat.format("Could not find company with id: {0}", id));
    }
}
