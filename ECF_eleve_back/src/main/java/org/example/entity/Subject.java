package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id", nullable = false)
    private Integer id;

    @Column(name = "subject_title", length = 50)
    private String subjectTitle;

    @Column(name = "subject_description", length = 500)
    private String subjectDescription;

    @Column(name = "subject_duration")
    private Integer subjectDuration;

    @Column(name = "subject_coefficient")
    private Integer subjectCoefficient;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<Teacher> teachers;

    public Subject(String subjectTitle, String subjectDescription, Integer subjectDuration, Integer subjectCoefficient, List<Teacher> teachers) {
        this.subjectTitle = subjectTitle;
        this.subjectDescription = subjectDescription;
        this.subjectDuration = subjectDuration;
        this.subjectCoefficient = subjectCoefficient;
        this.teachers = new ArrayList<>();
    }

    public Subject() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }

    public Integer getSubjectDuration() {
        return subjectDuration;
    }

    public void setSubjectDuration(Integer subjectDuration) {
        this.subjectDuration = subjectDuration;
    }

    public Integer getSubjectCoefficient() {
        return subjectCoefficient;
    }

    public void setSubjectCoefficient(Integer subjectCoefficient) {
        this.subjectCoefficient = subjectCoefficient;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}