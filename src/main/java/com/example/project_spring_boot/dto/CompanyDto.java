package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Company;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class CompanyDto {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private List<CourseDto> courseDto = new ArrayList<>();

    public static CompanyDto from(Company company) {
        CompanyDto CompanyDto = new CompanyDto();
        CompanyDto.setId(company.getId());
        CompanyDto.setCompanyName(company.getCompanyName());
        CompanyDto.setLocatedCountry(company.getLocatedCountry());
        CompanyDto.setCourseDto(company.getCourses().stream().map(CourseDto::from).collect(Collectors.toList()));
        return CompanyDto;
    }
}

