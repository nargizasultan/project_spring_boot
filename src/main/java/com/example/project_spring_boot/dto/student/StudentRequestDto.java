package com.example.project_spring_boot.dto.student;

import com.example.project_spring_boot.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {

    private String firstName;
    private String email;
    private String lastName;
    private StudyFormat studyFormat;
    private Long groupId;
}
