package bo.custom.impl;

import bo.custom.ProgrammeDetailsBO;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import entity.CustomEntity;
import entity.Programme;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeDetailsBOImpl implements ProgrammeDetailsBO {
    QueryDAOImpl queryDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.QUERY);
    ProgrammeDAOImpl programmeDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);

    @Override
    public List<CustomEntity> loadAllProgrammeDetails(String id) throws Exception {
        List<CustomEntity> all = queryDAO.getStudentDatails(id);
        ArrayList<CustomEntity> dtoList = new ArrayList<>();

        for (CustomEntity entity : all) {
            dtoList.add(entity);
        }
        return dtoList;
    }

    @Override
    public List getProgrammeids() {
        return programmeDAO.getProgrammeIDs();
    }

    @Override
    public Programme getProgrammeData(String id) throws Exception {
        return programmeDAO.find(id);
    }
}
