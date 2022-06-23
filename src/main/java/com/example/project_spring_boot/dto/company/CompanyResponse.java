package com.example.project_spring_boot.dto.company;

import com.example.project_spring_boot.models.Company;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private int sizeOfCourse;

    public static CompanyResponse from(Company company){
        CompanyResponse companyResponse = new CompanyResponse();
        companyResponse.setCompanyName(company.getCompanyName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
        companyResponse.setId(company.getId());
        companyResponse.setSizeOfCourse(company.getCourses().size());
        return companyResponse;
    }
}
