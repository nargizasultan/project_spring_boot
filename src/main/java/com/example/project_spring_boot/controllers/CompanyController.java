package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.company.CompanyRequestDto;

import com.example.project_spring_boot.dto.company.CompanyResponse;
import com.example.project_spring_boot.dto.delete.SimpleResponse;


import com.example.project_spring_boot.services.CompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@PreAuthorize("hasAuthority('BOSS')")
@Tag(name = "Company API", description ="User with role boss can add,update, delete or get all companies")

public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyResponse> save(@RequestBody final CompanyRequestDto companyDto) {
        return new ResponseEntity<>(companyService.save(companyDto), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<CompanyResponse>> getAllCompanies() {
        return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CompanyResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(companyService.findByCompanyId(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse deleteCompany(@PathVariable Long id) {
        return companyService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CompanyResponse> updateCompany(@PathVariable Long id, @RequestBody final CompanyRequestDto companyDto) {
        return new ResponseEntity<>(companyService.update(id, companyDto), HttpStatus.OK);
    }
}
