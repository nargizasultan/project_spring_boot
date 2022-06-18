package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.CompanyRequest;
import com.example.project_spring_boot.dto.CourseRequest;
import com.example.project_spring_boot.dto.SimpleResponse;

import com.example.project_spring_boot.models.Company;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/companies")

public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyRequest> save(@RequestBody final CompanyRequest request) {
        Company company = companyService.save(Company.from(request));
        return new ResponseEntity<>(CompanyRequest.from(company), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CompanyRequest>> getAllCompanies() {
        List<Company> companies = companyService.findAllCompanies();
        List<CompanyRequest>companyRequests=companies.stream().map(CompanyRequest::from).collect(Collectors.toList());
        return new ResponseEntity<>(companyRequests, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CompanyRequest> findById(@PathVariable final Long id) {
        Company company = companyService.findByCompanyId(id);
        return new ResponseEntity<>(CompanyRequest.from(company), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyRequest> updateCompany(@PathVariable Long id, @RequestBody final CompanyRequest companyRequest) {
        Company update = companyService.update(id, Company.from(companyRequest));
        return new ResponseEntity<>(CompanyRequest.from(update), HttpStatus.OK);
    }

    @PostMapping("/{companyId}/courses/{courseId}/add")
    public ResponseEntity<CompanyRequest> addGroupToCompany(@PathVariable final Long companyId, @PathVariable final Long courseId) {
        Company company = companyService.addCourseToCompany(companyId, courseId);
        return new ResponseEntity<>(CompanyRequest.from(company), HttpStatus.OK);
    }
    @DeleteMapping("/{companyId}/courses/{courseId}/remove")
    public ResponseEntity<CompanyRequest> removeGroupFromCompany(@PathVariable final Long companyId, @PathVariable final Long courseId) {
        Company company = companyService.removeCourseFromCompany(companyId, courseId);
        return new ResponseEntity<>(CompanyRequest.from(company), HttpStatus.OK);
    }



}
