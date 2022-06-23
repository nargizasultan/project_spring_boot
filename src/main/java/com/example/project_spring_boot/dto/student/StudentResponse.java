package com.example.project_spring_boot.dto.student;

import com.example.project_spring_boot.enums.StudyFormat;
import com.example.project_spring_boot.models.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class StudentResponse {
    private Long id;

    private String firstName;

    private String email;
    private String lastName;
    private StudyFormat studyFormat;

    public static StudentResponse from(Student student) {
        return new StudentResponse(student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getStudyFormat());

    }

    public static List<StudentResponse> from(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        for (Student s : students) {
            studentResponses.add(StudentResponse.from(s));
        }
        return studentResponses;
    }

}
