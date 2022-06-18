package com.example.project_spring_boot.models;

import com.example.project_spring_boot.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.MERGE;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String email;
    private String lastName;
    private StudyFormat studyFormat;
    @ManyToOne(cascade = MERGE)
    private Group group;
}
