package dao.custom.impl;

import dao.custom.QueryDAO;
import entity.CustomEntity;
import entity.Programme;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<CustomEntity> getStudentDatails(String id) throws Exception {
    SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
       Session session=sessionFactory.openSession();


        String hql="SELECT s.student_registerNumber,s.student_name,r.regDate FROM Student s INNER JOIN ProgrammeRejistration r ON s.student_registerNumber=r.student where r.programme=:programme";
        Query query = session.createQuery(hql);
        query.setParameter("programme",session.load(Programme.class,id));
        List<Object[]>list = query.list();
        List<CustomEntity>all=new ArrayList<>();
        for(Object[]objects:list){

            all.add(new CustomEntity(objects[0].toString(),objects[1].toString(),objects[2].toString()));
        }

        return all;
    }

    @Override
    public List<CustomEntity> getStudentCourses(String id) throws Exception {
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        String hql="SELECT p.programme_id,p.programme_name,r.regNumber,r.regDate FROM Programme p INNER JOIN ProgrammeRejistration r ON p.programme_id=r.programme where r.student=:student";
        Query query = session.createQuery(hql);
        query.setParameter("student",session.load(Student.class,id));
        List<Object[]>list = query.list();
        List<CustomEntity>all=new ArrayList<>();
        for(Object[]objects:list){
            all.add(new CustomEntity(Integer.parseInt(objects[2].toString()),objects[3].toString(),objects[0].toString(),objects[1].toString()));
        }

        return all;
    }
}
