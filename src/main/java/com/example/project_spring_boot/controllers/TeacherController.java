package com.example.project_spring_boot.controllers;

import com.example.project_spring_boot.dto.*;
import com.example.project_spring_boot.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
@CrossOrigin
public class TeacherController {
    private final TeacherService teacherService;
    @PostMapping("/save")
    public ResponseEntity<TeacherResponse> save(@RequestBody TeacherRequestDto teacherRequestDto) {

        return new ResponseEntity<>(teacherService.save(teacherRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getAll() {
        return new ResponseEntity<>(teacherService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<TeacherResponse> findById(@PathVariable Long id) {

        return new ResponseEntity<>(teacherService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return teacherService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherResponse> update(@PathVariable Long id,@RequestBody TeacherRequestDto teacherRequestDto) {

        return new ResponseEntity<>(teacherService.update( teacherRequestDto,id), HttpStatus.OK);
    }

}
