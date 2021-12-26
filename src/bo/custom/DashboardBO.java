package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;
import dto.StudentDTO;

import java.util.List;

public interface DashboardBO extends SuperBO {
    public List<StudentDTO> loadAllStudent() throws Exception;
    public List<ProgrammeDTO> loadAllProgramme() throws Exception;
}
