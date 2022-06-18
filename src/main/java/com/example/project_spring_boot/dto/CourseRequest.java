package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CourseRequest {
    private Long id;
    private String courseName;
    private int duration;
    private PlainCompanyDto plainCompanyDto;

    public static CourseRequest from(Course course) {
        CourseRequest courseRequest = new CourseRequest();
        courseRequest.setId(course.getId());
        courseRequest.setCourseName(course.getCourseName());
        courseRequest.setDuration(course.getDuration());
        if(Objects.nonNull(course.getCompany())){
            courseRequest.setPlainCompanyDto(PlainCompanyDto.from(course.getCompany()));
        }
        return courseRequest;
    }
}
