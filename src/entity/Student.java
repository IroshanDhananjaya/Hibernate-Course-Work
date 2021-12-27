package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student implements SuperEntity {
    @Id
    private String student_registerNumber;
    private String student_name;
    private String address;
    private String contact;
    private String gender;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<ProgrammeRejistration>rejistrations;

    public Student() {
    }

    public Student(String student_registerNumber, String student_name, String address, String contact, String gender) {
        this.student_registerNumber = student_registerNumber;
        this.student_name = student_name;
        this.address = address;
        this.contact = contact;
        this.setGender(gender);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<ProgrammeRejistration> getRejistrations() {
        return rejistrations;
    }

    public void setRejistrations(List<ProgrammeRejistration> rejistrations) {
        this.rejistrations = rejistrations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_registerNumber='" + student_registerNumber + '\'' +
                ", student_name='" + student_name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", gender='" + gender + '\'' +
                ", rejistrations=" + rejistrations +
                '}';
    }
}
