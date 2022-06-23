package com.example.project_spring_boot.controllers;


import com.example.project_spring_boot.dto.group.GroupRequestDto;
import com.example.project_spring_boot.dto.group.GroupResponse;
import com.example.project_spring_boot.dto.delete.SimpleResponse;
import com.example.project_spring_boot.services.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@CrossOrigin
@PreAuthorize("hasAnyAuthority('ADMIN', 'BOSS')")
@Tag(name="Group API", description = "User with role admin and boss can add, update, delete or get all groups")
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
