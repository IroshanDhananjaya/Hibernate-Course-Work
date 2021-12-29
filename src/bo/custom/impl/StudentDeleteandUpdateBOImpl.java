package bo.custom.impl;

import bo.custom.StudentDeleteandUpdateBO;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeRejistrationDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.CustomEntity;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDeleteandUpdateBOImpl implements StudentDeleteandUpdateBO {
    StudentDAOImpl studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    QueryDAOImpl queryDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.QUERY);
    ProgrammeRejistrationDAOImpl programmeRejistrationDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMMEREJISTRATION);

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

    @Override
    public List<CustomEntity> loadAllStudentProgramme(String id) throws Exception {
        List<CustomEntity> all = queryDAO.getStudentCourses(id);
        ArrayList<CustomEntity> dtoList = new ArrayList<>();

        for (CustomEntity entity : all) {
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public boolean removeProgrammeFromStudent(String id) throws Exception {
        return programmeRejistrationDAO.delete(id);
    }
}
