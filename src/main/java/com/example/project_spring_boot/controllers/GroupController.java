package com.example.project_spring_boot.controllers;


import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.models.Group;
import com.example.project_spring_boot.services.GroupService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@CrossOrigin
public class GroupController {
    private final GroupService groupService;

    @GetMapping
    public List<Group> getAll() {
        return groupService.findAllGroups();
    }

    @GetMapping("/find/{id}")
    public Group findById(@PathVariable Long id) {
        return groupService.findById(id);
    }

//    @PostMapping("/save")
//    public Group save(@RequestBody GroupRequest groupRequest) {
//        return groupService.save(groupRequest);
//    }

    @DeleteMapping("/delete/{id}")
    public SimpleResponse delete(@PathVariable Long id) {
        return groupService.deleteById(id);

    }

//    @PutMapping("/update/{id}")
//    public Group update(@PathVariable Long id,@RequestBody GroupRequest groupRequest) {
//        return groupService.update(id, groupRequest);
//    }


}
