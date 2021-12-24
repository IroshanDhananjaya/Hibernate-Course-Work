package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

public interface StudentManageBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;
}
