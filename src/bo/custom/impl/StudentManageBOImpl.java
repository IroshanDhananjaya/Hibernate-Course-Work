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
    public boolean addRejistration(ProgrammeRejistrationDTO pRegDTO) throws Exception {
      ProgrammeRejistration pReg=new ProgrammeRejistration();
      pReg.setRegNumber(pRegDTO.getRegId());
      pReg.setRegDate(pRegDTO.getDate());
      pReg.setProgramme(new Programme(pRegDTO.getProgrammeId()));
      pReg.setStudent(new Student(pRegDTO.getStudentId()));

      programmeRejistrationDAO.add(pReg);
      return true;

    }

    @Override
    public int getNewOrderId() throws Exception {
      int lastID=programmeRejistrationDAO.getLastOrderID();
      if (lastID==0){
          return 1;
      }
      int newID=(lastID+1);
      return newID;
    }
}
