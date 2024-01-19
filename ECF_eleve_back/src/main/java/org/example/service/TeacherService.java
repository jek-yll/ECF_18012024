package org.example.service;

import org.example.entity.Teacher;
import org.example.impl.TeacherDAOImpl;

import java.time.LocalDate;

public class TeacherService implements ITeacherService{

    private TeacherDAOImpl teacherDAO;

    public TeacherService(){
        teacherDAO = new TeacherDAOImpl();
    }

    @Override
    public boolean addTeacher(String registrationNbr, String firstname, String lastname, LocalDate dateBirth, Integer grade) {
        Teacher teacher = new Teacher(
                registrationNbr,
                firstname,
                lastname,
                dateBirth,
                grade
        );
        teacherDAO.create(teacher);
        return true;
    }
}
