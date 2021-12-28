package dao.custom;

import dao.CrudDAO;
import entity.ProgrammeRejistration;


public interface ProgrammeRejistrationDAO extends CrudDAO<ProgrammeRejistration,String> {
    public int getLastOrderID()throws Exception;
}
