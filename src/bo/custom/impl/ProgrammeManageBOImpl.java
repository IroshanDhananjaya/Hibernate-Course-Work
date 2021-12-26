package bo.custom.impl;

import bo.custom.ProgrammeManageBO;
import dao.DAOFactory;
import dao.custom.impl.ProgrammeDAOImpl;
import dto.ProgrammeDTO;
import entity.Programme;


import java.util.List;

public class ProgrammeManageBOImpl implements ProgrammeManageBO {
    ProgrammeDAOImpl programmeDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.PROGRAMME);
    @Override
    public boolean add(ProgrammeDTO programmeDTO) throws Exception {
       return programmeDAO.add(new Programme(programmeDTO.getProgramme_id(),programmeDTO.getProgramme_name(),programmeDTO.getDuration(),programmeDTO.getFee()));
    }

    @Override
    public Programme getProgrammeData(String id) throws Exception {
        return programmeDAO.find(id);
    }

    @Override
    public List getProgrammeids() {
       return programmeDAO.getProgrammeIDs();
    }

    @Override
    public boolean updateProgramme(ProgrammeDTO programmeDTO) throws Exception {
        return programmeDAO.update(new Programme(programmeDTO.getProgramme_id(),programmeDTO.getProgramme_name(),programmeDTO.getDuration(),programmeDTO.getFee()));
    }

    @Override
    public boolean removeProgramme(String id) throws Exception {
        return programmeDAO.delete(id);
    }
}
