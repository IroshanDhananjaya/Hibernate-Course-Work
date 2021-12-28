package dao.custom;

import dao.CrudDAO;
import entity.Programme;

import java.util.List;

public interface ProgrammeDAO extends CrudDAO<Programme,String> {
    public List getProgrammeIDs();

}
