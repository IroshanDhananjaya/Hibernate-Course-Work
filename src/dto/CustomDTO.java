package dto;

public class CustomDTO {
    private String studentId;
    private String studentName;
    private String studentAddress;
    private String gender;
    private String contact;
    private String regFormNumber;
    private String regDate;
    private String programmeId;

    public CustomDTO() {
    }

    public CustomDTO(String studentId, String studentName, String regDate) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.regDate = regDate;
    }

    public CustomDTO(String studentId, String studentName, String studentAddress, String gender, String contact, String regFormNumber, String regDate, String programmeId) {
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

    public String getRegFormNumber() {
        return regFormNumber;
    }

    public void setRegFormNumber(String regFormNumber) {
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
        return "CustomDTO{" +
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
}
