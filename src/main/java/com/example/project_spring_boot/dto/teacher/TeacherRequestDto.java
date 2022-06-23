package com.example.project_spring_boot.dto.teacher;

import lombok.Getter;
import lombok.Setter;



@Getter @Setter

public class TeacherRequestDto {

    private String firstName;
    private String email;
    private String lastName;
    private Long courseId;
}
