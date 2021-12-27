package dao.custom;

import dao.SuperDAO;
import entity.Programme;

import java.util.List;

public interface ProgrammeDAO extends SuperDAO<Programme,String> {
    public List getProgrammeIDs();

}
