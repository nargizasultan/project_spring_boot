package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentPaginationResponse {
    private int totalPage;
    private List<StudentResponse> students;
    private int currentPage;
}
