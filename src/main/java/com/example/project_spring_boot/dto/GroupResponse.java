package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;
    private int amountOfStudents;



    public static GroupResponse from(Group group){

        GroupResponse groupResponse=new GroupResponse();
        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        groupResponse.setAmountOfStudents(group.getStudents().size());
        return groupResponse;

    }


}
