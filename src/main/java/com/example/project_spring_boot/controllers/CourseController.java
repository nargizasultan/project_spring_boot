package com.example.project_spring_boot.controllers;


import com.example.project_spring_boot.dto.course.CourseRequestDto;
import com.example.project_spring_boot.dto.course.CourseResponse;
import com.example.project_spring_boot.dto.delete.SimpleResponse;
import com.example.project_spring_boot.services.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN', 'BOSS')")
@Tag(name="Course API", description = "User with role admin and boss can add, update, delete or get all courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<CourseResponse> save(@RequestBody final CourseRequestDto courseDto) {
        return new ResponseEntity<>(courseService.save(courseDto), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<CourseResponse>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<CourseResponse> findById(@PathVariable final Long id) {
        return new ResponseEntity<>(courseService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return courseService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CourseResponse> update(@PathVariable Long id, @RequestBody CourseRequestDto courseDto) {
        return new ResponseEntity<>(courseService.update(courseDto, id), HttpStatus.OK);
    }


}
