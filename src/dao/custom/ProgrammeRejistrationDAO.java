package dao.custom;

import dao.SuperDAO;
import entity.ProgrammeRejistration;


public interface ProgrammeRejistrationDAO extends SuperDAO<ProgrammeRejistration,String> {
    public String getLastOrderID()throws Exception;
}
