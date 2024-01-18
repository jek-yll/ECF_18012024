package org.example.impl;

import org.example.dao.IGradeStudentDAO;
import org.example.entity.GradeStudent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class GradeStudentDAOImpl implements IGradeStudentDAO {

    private EntityManagerFactory entityManagerFactory;

    public GradeStudentDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean addGradeStudent(GradeStudent gradeStudent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(gradeStudent);
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
