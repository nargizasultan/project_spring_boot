package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class CourseDto {
    private Long id;
    private String courseName;
    private int duration;
    private PlainCompanyDto plainCompanyDto;

    public static CourseDto from(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setCourseName(course.getCourseName());
        courseDto.setDuration(course.getDuration());
        if(Objects.nonNull(course.getCompany())){
            courseDto.setPlainCompanyDto(PlainCompanyDto.from(course.getCompany()));
        }
        return courseDto;
    }
}