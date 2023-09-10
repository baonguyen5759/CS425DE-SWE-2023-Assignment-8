package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;

@Entity
public class Transcript {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transcriptId;

    @Column(nullable = false)
    private String degreeTitle;

    public Transcript() {
    }
    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }
}
