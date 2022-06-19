package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.CompanyDto;

import com.example.project_spring_boot.dto.SimpleResponse;

import com.example.project_spring_boot.models.Company;

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
    public ResponseEntity<CompanyDto> save(@RequestBody final CompanyDto companyDto) {
        Company company = companyService.save(Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<Company> companies = companyService.findAllCompanies();
        List<CompanyDto>companyDto=companies.stream().map(CompanyDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(companyDto, HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CompanyDto> findById(@PathVariable final Long id) {
        Company company = companyService.findByCompanyId(id);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable Long id, @RequestBody final CompanyDto companyDto) {
        Company update = companyService.update(id, Company.from(companyDto));
        return new ResponseEntity<>(CompanyDto.from(update), HttpStatus.OK);
    }

    @PostMapping("/{companyId}/courses/{courseId}/add")
    public ResponseEntity<CompanyDto> addGroupToCompany(@PathVariable final Long companyId, @PathVariable final Long courseId) {
        Company company = companyService.addCourseToCompany(companyId, courseId);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }
    @DeleteMapping("/{companyId}/courses/{courseId}/remove")
    public ResponseEntity<CompanyDto> removeGroupFromCompany(@PathVariable final Long companyId, @PathVariable final Long courseId) {
        Company company = companyService.removeCourseFromCompany(companyId, courseId);
        return new ResponseEntity<>(CompanyDto.from(company), HttpStatus.OK);
    }



}
