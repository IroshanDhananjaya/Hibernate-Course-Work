package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import entity.CustomEntity;
import entity.Student;

import java.util.List;

public interface StudentDeleteandUpdateBO extends SuperBO {
    public Student getStudentDate(String id) throws Exception;
    public List getStudentids();
    public boolean updateStudentData(StudentDTO studentDto) throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public List<CustomEntity> loadAllStudentProgramme(String id) throws Exception;
    public boolean removeProgrammeFromStudent(String id) throws Exception;

}
