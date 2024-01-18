package org.example.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id", nullable = false)
    private Integer id;

    @Column(name = "registration_nbr", length = 50)
    private String registrationNbr;

    @Column(name = "teacher_firstname", nullable = false, length = 50)
    private String teacherFirstname;

    @Column(name = "teacher_lastname", nullable = false, length = 50)
    private String teacherLastname;

    @Column(name = "teacher_date_birth")
    private LocalDate teacherDateBirth;

    @Column(name = "teacher_grade")
    private Integer teacherGrade;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_teacher_class_id")
    private Class headTeacherClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "teach",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects ;

    @OneToMany(mappedBy = "teacher")
    private List<Timetable> timetables;

    public Teacher( String registrationNbr,
                    String teacherFirstname,
                    String teacherLastname,
                    LocalDate teacherDateBirth,
                    Integer teacherGrade,
                    Class headTeacherClass,
                    Department department,
                    List<Subject> subjects,
                    List<Timetable> timetables) {
        this.registrationNbr = registrationNbr;
        this.teacherFirstname = teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.teacherDateBirth = teacherDateBirth;
        this.teacherGrade = teacherGrade;
        this.headTeacherClass = headTeacherClass;
        this.department = department;
        this.subjects = new ArrayList<Subject>();
        this.timetables = new ArrayList<Timetable>() ;
    }

    public Teacher( String registrationNbr,
                    String teacherFirstname,
                    String teacherLastname,
                    LocalDate teacherDateBirth,
                    Integer teacherGrade
                    ){
        this.registrationNbr = registrationNbr;
        this.teacherFirstname =teacherFirstname;
        this.teacherLastname = teacherLastname;
        this.teacherDateBirth = teacherDateBirth;
        this.teacherGrade = teacherGrade;
    }

    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistrationNbr() {
        return registrationNbr;
    }

    public void setRegistrationNbr(String registrationNbr) {
        this.registrationNbr = registrationNbr;
    }

    public String getTeacherFirstname() {
        return teacherFirstname;
    }

    public void setTeacherFirstname(String teacherFirstname) {
        this.teacherFirstname = teacherFirstname;
    }

    public String getTeacherLastname() {
        return teacherLastname;
    }

    public void setTeacherLastname(String teacherLastname) {
        this.teacherLastname = teacherLastname;
    }

    public LocalDate getTeacherDateBirth() {
        return teacherDateBirth;
    }

    public void setTeacherDateBirth(LocalDate teacherDateBirth) {
        this.teacherDateBirth = teacherDateBirth;
    }

    public Integer getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(Integer teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public Class getHeadTeacherClass() {
        return headTeacherClass;
    }

    public void setHeadTeacherClass(Class headTeacherClass) {
        this.headTeacherClass = headTeacherClass;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }
}