package dao.custom;

import dao.SuperDAO;
import entity.CustomEntity;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<CustomEntity> getStudentDatails(String id) throws Exception;
}
