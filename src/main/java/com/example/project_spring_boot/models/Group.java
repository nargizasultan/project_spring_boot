package com.example.project_spring_boot.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public Group(String groupName, String dateOfStart, String dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public void setStudent(Student student) {
        this.students.add(student);
    }



}
