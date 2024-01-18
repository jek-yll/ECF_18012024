package org.example.impl;

import org.example.dao.BaseDAO;
import org.example.dao.ITeacherDAO;
import org.example.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TeacherDAOImpl extends BaseDAO implements ITeacherDAO {


    public TeacherDAOImpl() {
        super();
    }

}