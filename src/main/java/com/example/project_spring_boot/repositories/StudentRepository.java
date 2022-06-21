package com.example.project_spring_boot.repositories;

import com.example.project_spring_boot.models.Student;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s")
    Page<Student> findAllByPagination(Pageable pageable);
}
