package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long classroomId;

    private String buildingName;

    private String roomNumber;

    @ManyToMany(mappedBy = "classrooms", fetch = FetchType.LAZY)
    private List<Student> students;

    public Classroom() {
    }

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
    }
}
