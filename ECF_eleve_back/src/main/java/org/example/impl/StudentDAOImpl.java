package org.example.impl;

import org.example.dao.BaseDAO;
import org.example.dao.IStudentDAO;
import org.example.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class StudentDAOImpl extends BaseDAO implements IStudentDAO {

    private EntityManagerFactory entityManagerFactory;

    public StudentDAOImpl() {
        super();
    }

    @Override
    public boolean addStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

}
