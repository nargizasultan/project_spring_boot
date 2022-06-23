package com.example.project_spring_boot.services;


import com.example.project_spring_boot.dto.group.GroupRequestDto;
import com.example.project_spring_boot.dto.group.GroupResponse;
import com.example.project_spring_boot.dto.delete.SimpleResponse;
import com.example.project_spring_boot.exceptions.GroupNotfoundException;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.models.Group;
import com.example.project_spring_boot.repositories.CourseRepository;
import com.example.project_spring_boot.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    public List<GroupResponse> findAllGroups() {
        return groupRepository.findAll().stream().map(GroupResponse::from).collect(Collectors.toList());
    }

    public GroupResponse findById(Long id) {
        return GroupResponse.from(groupRepository.findById(id)
                .orElseThrow(() -> new GroupNotfoundException("Group with id : " + id + " not found")));
    }

    @Transactional

    public GroupResponse save(GroupRequestDto groupRequestDto) {
        Group group = new Group(groupRequestDto.getGroupName(), groupRequestDto.getDateOfStart(), groupRequestDto.getDateOfFinish());
        List<Course> courseList = courseRepository.findAllById(groupRequestDto.getCoursesId());
        group.setCourses(courseList);
        groupRepository.save(group);
        return GroupResponse.from(group);

    }

    public SimpleResponse deleteById(Long id) {
        boolean exists = groupRepository.existsById(id);
        if (!exists) {
            throw new GroupNotfoundException("Group with id : " + id + " not found");
        }
        groupRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Group successfully deleted");
    }

    @Transactional
    public GroupResponse update(Long id, GroupRequestDto groupRequestDto) {
        Group groupToEdit = groupRepository.findById(id).orElseThrow(() -> new GroupNotfoundException("Group with id : " + id + " not found"));
        groupToEdit.setGroupName(groupRequestDto.getGroupName());
        groupToEdit.setDateOfStart(groupRequestDto.getDateOfStart());
        groupToEdit.setDateOfFinish(groupRequestDto.getDateOfFinish());
        List<Course> courseList = courseRepository.findAllById(groupRequestDto.getCoursesId());
        groupToEdit.setCourses(courseList);
        return GroupResponse.from(groupToEdit);


    }

}
