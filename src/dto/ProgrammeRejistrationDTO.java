package dto;


public class ProgrammeRejistrationDTO {
     private int regId;
     private String date;
     private String studentId;
     private String programmeId;

    public ProgrammeRejistrationDTO() {
    }

    public ProgrammeRejistrationDTO(int regId, String date, String studentDTO, String programmeDTO) {
        this.regId = regId;
        this.date = date;
        this.studentId = studentDTO;
        this.programmeId = programmeDTO;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }
}
