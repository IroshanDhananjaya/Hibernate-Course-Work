package bo.custom.impl;

import bo.custom.StudentManageBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public class StudentManageBOImpl implements StudentManageBO {
    StudentDAOImpl studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
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
}
