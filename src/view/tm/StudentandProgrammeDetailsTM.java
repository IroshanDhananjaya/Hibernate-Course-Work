package view.tm;

public class StudentandProgrammeDetailsTM {
    private String s_id;
    private String sName;
    private String regDate;

    public StudentandProgrammeDetailsTM() {
    }

    public StudentandProgrammeDetailsTM(String s_id, String sName, String regDate) {
        this.s_id = s_id;
        this.sName = sName;
        this.regDate = regDate;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
