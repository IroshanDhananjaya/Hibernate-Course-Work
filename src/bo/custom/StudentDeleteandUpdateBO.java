package bo.custom;

import bo.SuperBO;
import entity.Student;

import java.util.List;

public interface StudentDeleteandUpdateBO extends SuperBO {
    public Student getStudentDate(String id) throws Exception;
    public List getStudentids();
}
