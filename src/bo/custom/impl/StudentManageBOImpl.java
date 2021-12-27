package bo.custom.impl;

import bo.custom.StudentManageBO;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeDAOImpl;
import dao.custom.impl.ProgrammeRejistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.ProgrammeDTO;
import dto.ProgrammeRejistrationDTO;
import dto.StudentDTO;
import entity.Programme;
import entity.ProgrammeRejistration;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class StudentManageBOImpl implements StudentManageBO {
    StudentDAOImpl studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    ProgrammeDAOImpl programmeDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);
    ProgrammeRejistrationDAOImpl programmeRejistrationDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMMEREJISTRATION);
    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(studentDTO.getStudent_registerNumber(),studentDTO.getStudent_name(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getGender()));
    }
    @Override
    public Student getStudentDate(String id) throws Exception {
        return studentDAO.find(id);
    }

    @Override
    public List getStudentids() {
        return studentDAO.getStudentIDs();
    }

    @Override
    public List getProgrammeids() {
        return programmeDAO.getProgrammeIDs();
    }

    @Override
    public Programme getProgrammeData(String id) throws Exception {
        return programmeDAO.find(id);
    }

    @Override
    public boolean addRejistration(ProgrammeRejistrationDTO programmeRejistrationDTO) throws Exception {
       StudentDTO studentDTO=programmeRejistrationDTO.getStudentDTO();
       Student student=new Student(studentDTO.getStudent_registerNumber(),studentDTO.getStudent_name(),studentDTO.getAddress(),studentDTO.getContact(),studentDTO.getGender());
       ProgrammeDTO programmeDTO=programmeRejistrationDTO.getProgramme();
       Programme programme=new Programme(programmeDTO.getProgramme_id(),programmeDTO.getProgramme_name(),programmeDTO.getDuration(),programmeDTO.getFee());
       return programmeRejistrationDAO.add(new ProgrammeRejistration(programmeRejistrationDTO.getId(),programmeRejistrationDTO.getDate(),student,programme));
    }

    @Override
    public String getNewOrderId() throws Exception {
       /* String lastRejId=null;
       *//* SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=null;

        try {
            transaction=session.beginTransaction();*//*
            lastRejId=programmeRejistrationDAO.getLastOrderID();
           *//* transaction.commit();
        }catch (Throwable t){
            transaction.rollback();
            throw t;
        }
        session.close();*//*

        if(lastRejId==null){
            return "0001";
        }else {
            int maxId=Integer.parseInt(lastRejId.replace("0",""));
            maxId=maxId+1;
            String id="";
            if(maxId<10){
                id="000"+maxId;
            }else if(maxId<100){
                id="00"+maxId;
            }else{
                id="0"+maxId;
            }
            return id;
        }*/
        return null;
    }
}
