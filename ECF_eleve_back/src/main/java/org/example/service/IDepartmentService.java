package org.example.service;

import javax.persistence.EntityManagerFactory;

public interface IDepartmentService <T>{

    public abstract boolean addDepartment(String name, Integer departmentManagerId );

}
