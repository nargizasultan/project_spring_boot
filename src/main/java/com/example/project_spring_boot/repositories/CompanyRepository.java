package com.example.project_spring_boot.repositories;

import com.example.project_spring_boot.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
