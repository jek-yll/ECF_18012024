package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Integer id;

    @Column(name = "department_name", length = 50)
    private String departmentName;

    @Column(name = "department_manager_id")
    private Integer departmentManagerId;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classe> classes ;

    public Department( String departmentName, Integer departmentManagerId) {
        this.departmentName = departmentName;
        this.departmentManagerId = departmentManagerId;
        this.classes = new ArrayList<>();
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDepartmentManagerId() {
        return departmentManagerId;
    }

    public void setDepartmentManagerId(Integer departmentManagerId) {
        this.departmentManagerId = departmentManagerId;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
}