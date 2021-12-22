package entity;

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
    @OneToMany(mappedBy = "student")
    private
    List<ProgrammeRejistration>programmeRejistrationList;


    public Student() {
    }

    public Student(String student_registerNumber, String student_name, String address, String contact) {
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

    public List<ProgrammeRejistration> getProgrammeRejistrationList() {
        return programmeRejistrationList;
    }

    public void setProgrammeRejistrationList(List<ProgrammeRejistration> programmeRejistrationList) {
        this.programmeRejistrationList = programmeRejistrationList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_registerNumber='" + student_registerNumber + '\'' +
                ", student_name='" + student_name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", programmeRejistrationList=" + programmeRejistrationList +
                '}';
    }
}
