package com.example.project_spring_boot.dto;


import com.example.project_spring_boot.models.Company;
import com.example.project_spring_boot.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CompanyRequest {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<CourseRequest> courseRequests = new ArrayList<>();

    public static CompanyRequest from(Company company) {
        CompanyRequest companyRequest = new CompanyRequest();
        companyRequest.setId(company.getId());
        companyRequest.setCompanyName(company.getCompanyName());
        companyRequest.setLocatedCountry(company.getLocatedCountry());
        companyRequest.setCourseRequests(company.getCourses().stream().map(CourseRequest::from).collect(Collectors.toList()));
        return companyRequest;
    }
}
