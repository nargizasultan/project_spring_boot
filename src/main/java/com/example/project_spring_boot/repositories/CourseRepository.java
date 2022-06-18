package com.example.project_spring_boot.repositories;

import com.example.project_spring_boot.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
