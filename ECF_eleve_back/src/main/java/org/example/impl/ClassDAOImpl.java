package org.example.impl;

import org.example.dao.BaseDAO;
import org.example.dao.IClassDAO;
import org.example.entity.Classe;

public class ClassDAOImpl extends BaseDAO implements IClassDAO {

    public ClassDAOImpl(){
        super();
    }


    @Override
    public Classe get(Integer id) {
        session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Classe classe = session.load(Classe.class, id);

            return classe;
        } catch (Exception e) {
            if (session.getTransaction().isActive()){
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

}
