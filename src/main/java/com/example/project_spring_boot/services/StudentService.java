package com.example.project_spring_boot.services;

import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.dto.StudentPaginationResponse;
import com.example.project_spring_boot.dto.StudentRequestDto;
import com.example.project_spring_boot.dto.StudentResponse;
import com.example.project_spring_boot.exceptions.GroupNotfoundException;
import com.example.project_spring_boot.exceptions.StudentNotFoundException;
import com.example.project_spring_boot.exceptions.TeacherNotFoundException;
import com.example.project_spring_boot.models.Student;
import com.example.project_spring_boot.repositories.GroupRepository;
import com.example.project_spring_boot.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    public StudentPaginationResponse findAll(int page, int size){
        StudentPaginationResponse studentPaginationResponse = new StudentPaginationResponse();

        Pageable pageable = PageRequest.of(page, size);
            studentPaginationResponse.setStudents((StudentResponse.from(studentRepository.findAllByPagination(pageable).getContent())));
            studentPaginationResponse.setCurrentPage(pageable.getPageNumber());
            studentPaginationResponse.setTotalPage(studentRepository.findAllByPagination(pageable).getTotalPages());
            return studentPaginationResponse;
    }


    public StudentResponse findById(Long id){
        return StudentResponse.from(studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id)));

    }
    public StudentResponse save(StudentRequestDto studentRequestDto){

       Student student=new Student(studentRequestDto.getFirstName(), studentRequestDto.getEmail(), studentRequestDto.getLastName(), studentRequestDto.getStudyFormat());
       student.setGroup(groupRepository.findById(studentRequestDto.getGroupId()).orElseThrow(GroupNotfoundException::new));
       return StudentResponse.from(studentRepository.save(student));
    }
    public SimpleResponse deleteById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new TeacherNotFoundException(id);

        }
        studentRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Student successfully deleted");
    }
    @Transactional
    public StudentResponse update(StudentRequestDto studentRequestDto, Long id) {

        Student student=studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException(id));
       student.setFirstName(studentRequestDto.getFirstName());
       student.setEmail(studentRequestDto.getEmail());
       student.setStudyFormat(studentRequestDto.getStudyFormat());
       student.setLastName(studentRequestDto.getLastName());
       student.setGroup(groupRepository.findById(studentRequestDto.getGroupId()).orElseThrow(GroupNotfoundException::new));

        return StudentResponse.from(student);
    }

}
