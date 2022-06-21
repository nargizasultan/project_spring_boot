package com.example.project_spring_boot.services;

import com.example.project_spring_boot.dto.*;
import com.example.project_spring_boot.exceptions.CourseNotFoundException;
import com.example.project_spring_boot.exceptions.TeacherNotFoundException;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.models.Teacher;
import com.example.project_spring_boot.repositories.CourseRepository;
import com.example.project_spring_boot.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public List<TeacherResponse>findAll(){
        return teacherRepository.findAll().stream().map(TeacherResponse::from).collect(Collectors.toList());

    }
    public TeacherResponse findById(Long id){
       return TeacherResponse.from(teacherRepository.findById(id).orElseThrow(()->new TeacherNotFoundException(id)));

    }
    public TeacherResponse save(TeacherRequestDto teacherRequestDto){
        Teacher teacher = new Teacher(teacherRequestDto.getFirstName(), teacherRequestDto.getEmail(), teacherRequestDto.getLastName());
        teacher.setCourse(courseRepository.findById(teacherRequestDto.getCourseId()).orElseThrow(CourseNotFoundException::new));
       return TeacherResponse.from(teacherRepository.save(teacher)) ;
        
    }
    public SimpleResponse deleteById(Long id) {
        boolean exists = teacherRepository.existsById(id);
        if (!exists) {
            throw new TeacherNotFoundException(id);

        }
        teacherRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Teacher successfully deleted");
    }
    @Transactional
    public TeacherResponse update(TeacherRequestDto teacherRequestDto, Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow();
       teacher.setEmail(teacherRequestDto.getEmail());
       teacher.setFirstName(teacherRequestDto.getFirstName());
       teacher.setLastName(teacherRequestDto.getLastName());
        return TeacherResponse.from(teacher);
    }


}
