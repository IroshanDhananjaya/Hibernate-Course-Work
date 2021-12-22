package dto;

public class StudentDTO {
     private String student_registerNumber;
     private String student_name;
     private String address;
     private String contact;

    public StudentDTO() {
    }

    public StudentDTO(String student_registerNumber, String student_name, String address, String contact) {
        this.student_registerNumber = student_registerNumber;
        this.student_name = student_name;
        this.address = address;
        this.contact = contact;
    }

    public String getStudent_registerNumber() {
        return student_registerNumber;
    }

    public void setStudent_registerNumber(String student_registerNumber) {
        this.student_registerNumber = student_registerNumber;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
