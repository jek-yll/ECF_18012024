package org.example.service;

import org.example.entity.Department;
import org.example.impl.DepartmentDAOImpl;

public class DepartmentService implements IDepartmentService{

    private DepartmentDAOImpl departmentDAO;

    public DepartmentService(){
        departmentDAO = new DepartmentDAOImpl();
    }

    @Override
    public boolean addDepartment(String name, Integer departmentManagerId) {
        Department department = new Department(name, departmentManagerId);
        departmentDAO.create(department);
        return true;
    }

}
