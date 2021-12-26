package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public interface StudentManageBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;
    public Student getStudentDate(String id) throws Exception;
    public List getStudentids();
}
