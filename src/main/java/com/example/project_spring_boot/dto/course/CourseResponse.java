package com.example.project_spring_boot.dto.course;

import com.example.project_spring_boot.models.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {
    private Long id;
    private String courseName;
    private int duration;
    private int sizeOfGroups;
    private boolean hasATeacher=false;

    public static CourseResponse from(Course course) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setSizeOfGroups(course.getGroups().size());
       if (course.getTeacher()!=null){
           courseResponse.hasATeacher=true;
       }
        return courseResponse;
    }
}
