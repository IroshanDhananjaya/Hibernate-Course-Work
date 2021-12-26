package bo;

import bo.custom.impl.DashboardBOImpl;
import bo.custom.impl.ProgrammeManageBOImpl;
import bo.custom.impl.StudentDeleteandUpdateBOImpl;
import bo.custom.impl.StudentManageBOImpl;

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
            default:
                return null;
        }
    }

    public enum BoTypes {
            MANAGESTUDENT,MANAGEPROGRAMME,STUDENTDELETEANDUPDATE,DASHBOARD
     }

}
