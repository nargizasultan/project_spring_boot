package com.example.project_spring_boot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GroupRequest {
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;
}