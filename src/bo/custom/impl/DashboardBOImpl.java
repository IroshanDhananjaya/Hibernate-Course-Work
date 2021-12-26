package bo.custom.impl;

import bo.custom.DashboardBO;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.impl.ProgrammeDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dto.ProgrammeDTO;
import dto.StudentDTO;
import entity.Programme;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class DashboardBOImpl implements DashboardBO {
    StudentDAOImpl studentDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.STUDENT);
    ProgrammeDAOImpl programmeDAO=DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);

    @Override
    public List<StudentDTO> loadAllStudent() throws Exception {
        List<Student> all = studentDAO.findAll();
        ArrayList<StudentDTO> dtoList = new ArrayList<>();

        StudentDTO customerDTO = null;

        for (Student student : all) {
            dtoList.add(new StudentDTO(student.getStudent_registerNumber(),student.getStudent_name(),student.getAddress(),student.getContact(),student.getGender()));
        }
        return dtoList;
    }

    @Override
    public List<ProgrammeDTO> loadAllProgramme() throws Exception {
        List<Programme>all=programmeDAO.findAll();
        ArrayList<ProgrammeDTO> dtoList = new ArrayList<>();

        StudentDTO customerDTO = null;

        for (Programme programme : all) {
            dtoList.add(new ProgrammeDTO(programme.getProgramme_id(),programme.getProgramme_name(),programme.getDuration(),programme.getFee()));
        }
        return dtoList;
    }
}
