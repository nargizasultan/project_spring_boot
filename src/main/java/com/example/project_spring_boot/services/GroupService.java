package com.example.project_spring_boot.services;

import com.example.project_spring_boot.dto.GroupRequest;
import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.exceptions.CompanyNotFoundException;
import com.example.project_spring_boot.exceptions.GroupNotfoundException;
import com.example.project_spring_boot.models.Group;
import com.example.project_spring_boot.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    public List<Group>findAllGroups(){
       return groupRepository.findAll();
    }
    public Group findById(Long id){
        return groupRepository.findById(id).orElseThrow(()->new GroupNotfoundException("Group with id : " + id + " not found"));
    }
    public Group save(GroupRequest groupRequest){
        Group group = new Group(groupRequest.getGroupName(), groupRequest.getDateOfStart(), groupRequest.getDateOfFinish());
       return groupRepository.save(group);
    }
    public SimpleResponse deleteById(Long id){
        boolean exists = groupRepository.existsById(id);
        if(!exists){
            throw new GroupNotfoundException("Group with id : " + id + " not found");
        }
        groupRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Group successfully deleted");
    }
    @Transactional
    public Group update(Long id, GroupRequest groupRequest){
        Group group = groupRepository.findById(id).get();
        System.out.println(groupRequest.getGroupName());
        System.out.println(group.getId());
        group.setGroupName(groupRequest.getGroupName());
        System.out.println(group.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        System.out.println(group.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());
        System.out.println(group.getDateOfFinish());
        return group;
    }
}
