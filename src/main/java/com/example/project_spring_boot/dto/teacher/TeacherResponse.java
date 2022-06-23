package com.example.project_spring_boot.dto.teacher;

import com.example.project_spring_boot.models.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;


    public static TeacherResponse from(Teacher teacher){
        return new TeacherResponse(teacher.getId(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());

    }
}
