package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "grade_student")
public class GradeStudent {
    @EmbeddedId
    private GradeStudentId id;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @MapsId("subjectId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(name = "grade_student_value")
    private Integer gradeStudentValue;

    @Column(name = "grade_student_comment", length = 500)
    private String gradeStudentComment;

    public GradeStudentId getId() {
        return id;
    }

    public void setId(GradeStudentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getGradeStudentValue() {
        return gradeStudentValue;
    }

    public void setGradeStudentValue(Integer gradeStudentValue) {
        this.gradeStudentValue = gradeStudentValue;
    }

    public String getGradeStudentComment() {
        return gradeStudentComment;
    }

    public void setGradeStudentComment(String gradeStudentComment) {
        this.gradeStudentComment = gradeStudentComment;
    }

}