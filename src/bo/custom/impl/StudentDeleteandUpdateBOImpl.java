package bo.custom.impl;

import bo.custom.StudentDeleteandUpdateBO;
import dao.DAOFactory;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public class StudentDeleteandUpdateBOImpl implements StudentDeleteandUpdateBO {
    StudentDAOImpl studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);

    @Override
    public Student getStudentDate(String id) throws Exception {
       return studentDAO.find(id);
    }

    @Override
    public List getStudentids() {
        return studentDAO.getStudentIDs();
    }

    @Override
    public boolean updateStudentData(StudentDTO studentDto) throws Exception {
        return studentDAO.update(new Student(studentDto.getStudent_registerNumber(),studentDto.getStudent_name(),studentDto.getAddress(),studentDto.getContact(),studentDto.getGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }
}
