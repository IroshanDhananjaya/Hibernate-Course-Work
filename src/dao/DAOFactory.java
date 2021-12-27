package dao;

import dao.custom.impl.ProgrammeDAOImpl;
import dao.custom.impl.ProgrammeRejistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public <T extends SuperDAO>T getDAO(DAOType type){
        switch (type){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case PROGRAMME:
                return (T) new ProgrammeDAOImpl();
            case PROGRAMMEREJISTRATION:
                return (T) new ProgrammeRejistrationDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOType{
        STUDENT,PROGRAMME,PROGRAMMEREJISTRATION
    }
}
