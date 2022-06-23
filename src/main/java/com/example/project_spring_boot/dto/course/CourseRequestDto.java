package com.example.project_spring_boot.dto.course;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseRequestDto {
    private String courseName;
    private int duration;
    private Long companyId;
}