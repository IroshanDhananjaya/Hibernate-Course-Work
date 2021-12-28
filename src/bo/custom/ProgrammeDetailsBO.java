package bo.custom;

import bo.SuperBO;
import entity.CustomEntity;

import java.util.List;

public interface ProgrammeDetailsBO extends SuperBO {
    public List<CustomEntity> loadAllProgrammeDetails(String id) throws Exception;
    public List getProgrammeids();
}
