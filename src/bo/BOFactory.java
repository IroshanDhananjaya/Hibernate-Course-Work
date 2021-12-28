package bo;

import bo.custom.impl.*;

public class BOFactory {
        private static BOFactory boFactory;

        private BOFactory() {
        }

        public static BOFactory getBOFactory() {
            if (boFactory == null) {
                boFactory = new BOFactory();
            }
            return boFactory;
        }
    public <T extends SuperBO> T getBO(BoTypes boType){
        switch (boType){
            case  MANAGESTUDENT:
                return (T) new StudentManageBOImpl();
            case MANAGEPROGRAMME:
                return (T) new ProgrammeManageBOImpl();
            case STUDENTDELETEANDUPDATE:
                return (T) new StudentDeleteandUpdateBOImpl();
            case DASHBOARD:
                return (T)new DashboardBOImpl();
            case PROGRAMMEDETAILS:
                return (T) new ProgrammeDetailsBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
            MANAGESTUDENT,MANAGEPROGRAMME,STUDENTDELETEANDUPDATE,DASHBOARD,PROGRAMMEDETAILS;
     }

}
