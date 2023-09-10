package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    @Column(nullable = false)
    private String studentNumber;

    @Column(nullable = false)
    private String firstName;

    @Column
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private Float cgpa;

    private LocalDate dateOfEnrollment;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_transcript"
            , joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "transcript_id"))
    private List<Transcript> transcripts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_classroom"
            , joinColumns = @JoinColumn(name = "student_id")
            , inverseJoinColumns = @JoinColumn(name = "classroom_id"))
    private List<Classroom> classrooms;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = LocalDate.now();
    }

    public Student(String studentNumber, String firstName, String middleName, String lastName, Float cgpa, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public List<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(List<Transcript> transcripts) {
        this.transcripts = transcripts;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }
}
