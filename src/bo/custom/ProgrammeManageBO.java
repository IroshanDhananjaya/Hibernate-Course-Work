package bo.custom;

import bo.SuperBO;
import dto.ProgrammeDTO;
import entity.Programme;


import java.util.List;

public interface ProgrammeManageBO extends SuperBO {
    public boolean add(ProgrammeDTO programmeDTO) throws Exception;
    public Programme getProgrammeData(String id) throws Exception;
    public List getProgrammeids();

}
