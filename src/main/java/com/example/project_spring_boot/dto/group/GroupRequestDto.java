package com.example.project_spring_boot.dto.group;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class GroupRequestDto {
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;

    private List<Long> coursesId = new ArrayList<>();
}
