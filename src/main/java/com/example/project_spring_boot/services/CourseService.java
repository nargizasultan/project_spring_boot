package com.example.project_spring_boot.services;


import com.example.project_spring_boot.dto.course.CourseRequestDto;
import com.example.project_spring_boot.dto.course.CourseResponse;
import com.example.project_spring_boot.dto.delete.SimpleResponse;

import com.example.project_spring_boot.exceptions.CompanyNotFoundException;
import com.example.project_spring_boot.exceptions.CourseNotFoundException;

import com.example.project_spring_boot.models.Course;

import com.example.project_spring_boot.repositories.CompanyRepository;
import com.example.project_spring_boot.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CompanyRepository companyRepository;

    public List<CourseResponse> findAll() {
        return courseRepository.findAll().stream().map(CourseResponse::from).collect(Collectors.toList());
    }

    public CourseResponse findById(Long id) {
        return CourseResponse.from(courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new));
    }

    public CourseResponse save(CourseRequestDto courseRequestDto) {
        Course course = new Course(courseRequestDto.getCourseName(), courseRequestDto.getDuration());
        course.setCompany(companyRepository.findById(courseRequestDto.getCompanyId()).orElseThrow(CompanyNotFoundException::new));
        courseRepository.save(course);
        return CourseResponse.from(course);
    }

    public SimpleResponse deleteById(Long id) {
        boolean exists = courseRepository.existsById(id);
        if (!exists) {
            throw new CourseNotFoundException();

        }
        courseRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Course successfully deleted");
    }

    @Transactional
    public CourseResponse update(CourseRequestDto courseRequestDto, Long id) {
        Course course1 = courseRepository.findById(id).orElseThrow();
        course1.setCourseName(courseRequestDto.getCourseName());
        course1.setDuration(courseRequestDto.getDuration());
        course1.setCompany(companyRepository.findById(courseRequestDto.getCompanyId()).orElseThrow(CompanyNotFoundException::new));
        return CourseResponse.from(course1);
    }


}
