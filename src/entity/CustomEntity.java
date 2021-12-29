package entity;

public class CustomEntity {
    private String studentId;
    private String studentName;
    private String studentAddress;
    private String gender;
    private String contact;
    private int regFormNumber;
    private String regDate;
    private String programmeId;
    private String programmeName;

    public CustomEntity() {
    }

    public CustomEntity(int regFormNumber, String regDate, String programmeId, String programmeName) {
        this.regFormNumber = regFormNumber;
        this.regDate = regDate;
        this.programmeId = programmeId;
        this.programmeName = programmeName;
    }

    public CustomEntity(String studentId, String studentName, String regDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.regDate = regDate;
    }

    public CustomEntity(String studentId, String studentName, String studentAddress, String gender, String contact, int regFormNumber, String regDate, String programmeId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.gender = gender;
        this.contact = contact;
        this.regFormNumber = regFormNumber;
        this.regDate = regDate;
        this.programmeId = programmeId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getRegFormNumber() {
        return regFormNumber;
    }

    public void setRegFormNumber(int regFormNumber) {
        this.regFormNumber = regFormNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(String programmeId) {
        this.programmeId = programmeId;
    }

    @Override
    public String toString() {
        return "CustomEntity{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", gender='" + gender + '\'' +
                ", contact='" + contact + '\'' +
                ", regFormNumber='" + regFormNumber + '\'' +
                ", regDate='" + regDate + '\'' +
                ", programmeId='" + programmeId + '\'' +
                '}';
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }
}
