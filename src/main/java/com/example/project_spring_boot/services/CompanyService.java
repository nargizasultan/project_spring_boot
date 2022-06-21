package com.example.project_spring_boot.services;


import com.example.project_spring_boot.dto.CompanyRequestDto;
import com.example.project_spring_boot.dto.CompanyResponse;
import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.exceptions.CompanyNotFoundException;
import com.example.project_spring_boot.models.Company;
import com.example.project_spring_boot.repositories.CompanyRepository;
import com.example.project_spring_boot.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;



    public List<CompanyResponse> findAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyResponse::from)
                .collect(Collectors.toList());
    }

    public CompanyResponse findByCompanyId(Long id) {
        Company company = companyRepository.findById(id).orElseThrow();
        return CompanyResponse.from(company);
    }

    public CompanyResponse save(CompanyRequestDto companyRequestDto) {
        return CompanyResponse.from(companyRepository
                .save(new Company(companyRequestDto
                        .getCompanyName(), companyRequestDto.getLocatedCountry())));
    }

    public SimpleResponse deleteById(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (!exists) {
            throw new CompanyNotFoundException();
        }
        companyRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Company successfully deleted");

    }

    @Transactional
    public CompanyResponse update(Long id, CompanyRequestDto companyRequestDto) {
        Company company = companyRepository.findById(id).get();
        company.setCompanyName(companyRequestDto.getCompanyName());
        company.setLocatedCountry(companyRequestDto.getLocatedCountry());
        return CompanyResponse.from(company);
    }
}
