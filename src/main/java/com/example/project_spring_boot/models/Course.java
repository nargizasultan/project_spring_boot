package com.example.project_spring_boot.models;

import com.example.project_spring_boot.dto.course.CourseRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private int duration;
    @ManyToOne
    private Company company;
    @ManyToMany(mappedBy = "courses", cascade = {MERGE})
    private List<Group> groups = new ArrayList<>();

    @OneToOne(mappedBy = "course",
            cascade = {REMOVE},
            orphanRemoval = true)
    private Teacher teacher;

    public void setGroup(Group group) {
        this.groups.add(group);
    }

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public void removeCompany(){
        this.company=null;
    }
    public void removeGroup(Group group){
        this.groups.remove(group);
    }
    public static Course from(CourseRequestDto courseDto){
        Course course = new Course();
        course.setCourseName(courseDto.getCourseName());
        course.setDuration(courseDto.getDuration());
        return course;
    }
}

