package entity;

import javax.persistence.*;

@Entity
public class ProgrammeRejistration implements SuperEntity {
    @Id
    private
    int regNumber;
    private String regDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_registerNumber",referencedColumnName = "student_registerNumber")
    private
    Student student;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "programme_id",referencedColumnName = "programme_id")
    private
    Programme programme;

    public ProgrammeRejistration() {
    }

    public ProgrammeRejistration(int regNumber, String regDate, Student student, Programme programme) {
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.student = student;
        this.programme = programme;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Programme getProgramme() {
        return programme;
    }

    public void setProgramme(Programme programme) {
        this.programme = programme;
    }
}