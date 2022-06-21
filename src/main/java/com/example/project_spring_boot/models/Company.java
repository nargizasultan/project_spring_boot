package com.example.project_spring_boot.models;

import com.example.project_spring_boot.dto.CompanyRequestDto;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;



@Entity
@Table(name = "companies")
@Getter
@Setter


public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String locatedCountry;

    @OneToMany( cascade =ALL,mappedBy = "company")
    private List<Course> courses = new ArrayList<>();

    public Company() {

    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

}

