package com.example.project_spring_boot.models;

import com.example.project_spring_boot.dto.CourseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

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
    public void removeCompany(){
        this.company=null;
    }
    public static Course from(CourseDto courseDto){
        Course course = new Course();
        course.setCourseName(courseDto.getCourseName());
        course.setDuration(courseDto.getDuration());
        return course;
    }
}

