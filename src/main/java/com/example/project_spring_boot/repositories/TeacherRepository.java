package com.example.project_spring_boot.repositories;

import com.example.project_spring_boot.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
