package dao.custom.impl;

import dao.custom.ProgrammeRejistrationDAO;
import entity.ProgrammeRejistration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
    public int getLastOrderID() throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery query=session.createSQLQuery("SELECT regNumber FROM ProgrammeRejistration ORDER BY regNumber DESC LIMIT 1");
        int rst= (int) query.uniqueResult();
        transaction.commit();
        return rst;
    }
}
