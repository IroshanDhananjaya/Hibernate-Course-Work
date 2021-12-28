package bo.custom;

import bo.SuperBO;
import dto.ProgrammeRejistrationDTO;
import dto.StudentDTO;
import entity.Programme;
import entity.Student;

import java.util.List;

public interface StudentManageBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;
    public Student getStudentDate(String id) throws Exception;
    public List getStudentids();
    public List getProgrammeids();
    public Programme getProgrammeData(String id) throws Exception;
    public boolean addRejistration(ProgrammeRejistrationDTO programmeRejistrationDTO) throws Exception;
    public int getNewOrderId() throws Exception;

}
