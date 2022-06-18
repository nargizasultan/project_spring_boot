package com.example.project_spring_boot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    @OneToOne
    private Course course;


}
