package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.CourseRequest;
import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor

public class CourseController {
    private final CourseService courseService;
    @PostMapping("/save")
    public ResponseEntity<CourseRequest>save(@RequestBody final CourseRequest courseRequest){
        Course course=courseService.save(Course.from(courseRequest));
        return new ResponseEntity<>(CourseRequest.from(course), HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<List<CourseRequest>>findAll(){
        List<Course> courses = courseService.findAll();
        List<CourseRequest>courseRequests=courses.stream().map(CourseRequest::from).collect(Collectors.toList());
        return new ResponseEntity<>(courseRequests, HttpStatus.OK);
    }




    @GetMapping("/find/{id}")
    public ResponseEntity<CourseRequest> findById( @PathVariable final Long id){
        Course course = courseService.findById(id);
        return new ResponseEntity<>(CourseRequest.from(course), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return courseService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CourseRequest> update(@PathVariable Long id, @RequestBody CourseRequest courseRequest){
        Course update = courseService.update(id, Course.from(courseRequest));
        return new ResponseEntity<>(CourseRequest.from(update), HttpStatus.OK);

    }
}
