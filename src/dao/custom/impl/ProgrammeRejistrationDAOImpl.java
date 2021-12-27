package dao.custom.impl;

import dao.custom.ProgrammeRejistrationDAO;
import entity.ProgrammeRejistration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class ProgrammeRejistrationDAOImpl implements ProgrammeRejistrationDAO {
    @Override
    public boolean add(ProgrammeRejistration entity) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(ProgrammeRejistration entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public ProgrammeRejistration find(String s) throws Exception {
        return null;
    }

    @Override
    public List<ProgrammeRejistration> findAll() throws Exception {
        return null;
    }

    @Override
    public String getLastOrderID() throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        List list=session.createQuery("SELECT id FROM ProgrammeRejistration ORDER BY id desc ").setMaxResults(1).list();
        session.close();
        return (list.size() >0)?(String)list.get(0):null;
    }
}
