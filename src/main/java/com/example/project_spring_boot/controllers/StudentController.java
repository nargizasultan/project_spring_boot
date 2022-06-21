package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.*;
import com.example.project_spring_boot.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@CrossOrigin
public class StudentController {
    private final StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<StudentResponse> save(@RequestBody StudentRequestDto studentRequestDto) {

        return new ResponseEntity<>(studentService.save(studentRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StudentPaginationResponse> getAll(@RequestParam(required = false) int page, @RequestParam(required = false) int size) {
        return new ResponseEntity<>(studentService.findAll(page, size), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<StudentResponse> findById(@PathVariable Long id) {

        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return studentService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponse> update(@PathVariable Long id,@RequestBody StudentRequestDto studentRequestDto) {

        return new ResponseEntity<>(studentService.update(studentRequestDto, id ), HttpStatus.OK);
    }
}
