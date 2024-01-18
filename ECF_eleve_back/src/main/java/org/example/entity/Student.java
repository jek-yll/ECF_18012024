package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    private Integer id;

    @Column(name = "student_firstname", nullable = false, length = 50)
    private String studentFirstname;

    @Column(name = "student_lastname", nullable = false, length = 50)
    private String studentLastname;

    @Column(name = "student_email")
    private String studentEmail;

    @Column(name = "student_date_birth")
    private LocalDate studentDateBirth;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    @OneToMany(mappedBy = "student")
    private List<GradeStudent> gradeStudents;

    public Student(Integer id, String studentFirstname, String studentLastname, String studentEmail, LocalDate studentDateBirth, Class classField, List<GradeStudent> gradeStudents) {
        this.id = id;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.studentEmail = studentEmail;
        this.studentDateBirth = studentDateBirth;
        this.classField = classField;
        this.gradeStudents = gradeStudents;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public LocalDate getStudentDateBirth() {
        return studentDateBirth;
    }

    public void setStudentDateBirth(LocalDate studentDateBirth) {
        this.studentDateBirth = studentDateBirth;
    }

    public Class getClassField() {
        return classField;
    }

    public void setClassField(Class classField) {
        this.classField = classField;
    }

    public List<GradeStudent> getGradeStudents() {
        return gradeStudents;
    }

    public void setGradeStudents(List<GradeStudent> gradeStudents) {
        this.gradeStudents = gradeStudents;
    }
}