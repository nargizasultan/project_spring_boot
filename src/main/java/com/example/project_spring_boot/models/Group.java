package com.example.project_spring_boot.models;

import com.example.project_spring_boot.dto.GroupRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupName;

    private String dateOfStart;

    private String dateOfFinish;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public Group(String groupName, String dateOfStart, String dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public static Group from(GroupRequestDto groupRequestDto){
        Group group=new Group(groupRequestDto.getGroupName(), groupRequestDto.getDateOfStart(), groupRequestDto.getDateOfFinish());

        return group;
    }



//    public void setStudent(Student student) {
//        this.students.add(student);
//    }
//    public static Group from(GroupDto groupDto){
//        Group group=new Group();
//        group.setGroupName(groupDto.getGroupName());
//        group.setDateOfStart(groupDto.getDateOfStart());
//        group.setDateOfFinish(groupDto.getDateOfFinish());
//        return group;
//    }



}
