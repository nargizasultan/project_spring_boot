package com.example.project_spring_boot.controllers;


import com.example.project_spring_boot.dto.CourseDto;
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
    public ResponseEntity<CourseDto>save(@RequestBody final CourseDto courseDto){
        Course course=courseService.save(Course.from(courseDto));
        return new ResponseEntity<>(CourseDto.from(course), HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<List<CourseDto>>findAll(){
        List<Course> courses = courseService.findAll();
        List<CourseDto>courseDto=courses.stream().map(CourseDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(courseDto, HttpStatus.OK);
    }




    @GetMapping("/find/{id}")
    public ResponseEntity<CourseDto> findById( @PathVariable final Long id){
        Course course = courseService.findById(id);
        return new ResponseEntity<>(CourseDto.from(course), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id){
        return courseService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable Long id, @RequestBody CourseDto courseDto){
        Course update = courseService.update(id, Course.from(courseDto));
        return new ResponseEntity<>(CourseDto.from(update), HttpStatus.OK);
    }
//    @PostMapping("{courseId}/company/{companyId}/add")
//    public ResponseEntity<CourseDto>addCompanyToGroup(@PathVariable Long companyId, @PathVariable Long courseId){
//        Course course = courseService.addCompanyToCourse(courseId, companyId);
//        return new ResponseEntity<>(CourseDto.from(course), HttpStatus.OK);
//    }
//    @DeleteMapping("/{courseId}/company/delete")
//    public ResponseEntity<CourseDto>removeCompanyFromGroup(@PathVariable Long courseId){
//        Course course = courseService.removeCompanyFromCourse(courseId);
//        return new ResponseEntity<>(CourseDto.from(course), HttpStatus.OK);
//    }

}
