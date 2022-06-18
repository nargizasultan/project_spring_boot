package com.example.project_spring_boot.services;


import com.example.project_spring_boot.dto.SimpleResponse;

import com.example.project_spring_boot.exceptions.CourseNotFoundException;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException());
    }

    public Course save(Course course) {

       return courseRepository.save(course);
    }
    public SimpleResponse deleteById(Long id){
        boolean exists = courseRepository.existsById(id);
        if(!exists){
            throw  new CourseNotFoundException();

        }
        courseRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Course successfully deleted");
    }

    @Transactional
    public Course update(Long id, Course course){
        Course course1 = findById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        return course1;
    }

}
