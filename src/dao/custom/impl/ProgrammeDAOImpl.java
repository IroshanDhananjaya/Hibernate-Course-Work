package dao.custom.impl;

import dao.custom.ProgrammeDAO;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeDAOImpl implements ProgrammeDAO {
    @Override
    public boolean add(Programme entity) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Programme entity) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Programme programme=session.get(Programme.class,s);
        session.delete(programme);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Programme find(String id) throws Exception {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Programme programme=session.get(Programme.class,id);
        transaction.commit();
        session.close();
        return programme;
    }

    @Override
    public List<Programme> findAll() throws Exception {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Programme> list = null;
        Query programme = session.createQuery("from Programme ");
        list = programme.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List getProgrammeIDs() {
        List<String> programmeIds=new ArrayList<>();
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select programme_id from Programme ");
        programmeIds=query.list();
        transaction.commit();
        session.close();
        return programmeIds;
    }
}
