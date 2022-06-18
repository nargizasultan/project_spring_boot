package com.example.project_spring_boot.models;

import com.example.project_spring_boot.dto.CourseRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn
    private Company company;
//    @ManyToMany(mappedBy = "courses", cascade = {REMOVE})
//    private List<Group> groups = new ArrayList<>();
//
//    @OneToOne(mappedBy = "course",
//            cascade = {REMOVE},
//            orphanRemoval = true)
//    private Teacher teacher;

//    public void setGroup(Group group) {
//        this.groups.add(group);
//    }

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    public static Course from(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        return course;
    }
}

