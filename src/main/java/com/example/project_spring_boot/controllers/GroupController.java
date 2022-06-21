package com.example.project_spring_boot.controllers;


import com.example.project_spring_boot.dto.GroupRequestDto;
import com.example.project_spring_boot.dto.GroupResponse;
import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@CrossOrigin
public class GroupController {
    private final GroupService groupService;


    @PostMapping("/save")
    public ResponseEntity<GroupResponse> save(@RequestBody GroupRequestDto groupRequestDto) {

        return new ResponseEntity<>(groupService.save(groupRequestDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupResponse>> getAll() {
        return new ResponseEntity<>(groupService.findAllGroups(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GroupResponse> findById(@PathVariable Long id) {

        return new ResponseEntity<>(groupService.findById(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return groupService.deleteById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<GroupResponse> update(@PathVariable Long id,@RequestBody GroupRequestDto groupRequestDto) {

        return new ResponseEntity<>(groupService.update(id, groupRequestDto), HttpStatus.OK);
    }


}
