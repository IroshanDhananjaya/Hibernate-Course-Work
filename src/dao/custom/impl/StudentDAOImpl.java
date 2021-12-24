package dao.custom.impl;

import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student entity) throws Exception {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }


    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Student find(String id) throws Exception {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Student student=session.get(Student.class,id);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> findAll() throws Exception {
        return null;
    }

    @Override
    public List getStudentIDs() {
       List<String> studentIds=new ArrayList<>();
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("select student_registerNumber from Student");
        studentIds=query.list();
        transaction.commit();
        session.close();
        return studentIds;

    }


}
