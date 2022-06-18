package com.example.project_spring_boot.repositories;

import com.example.project_spring_boot.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
