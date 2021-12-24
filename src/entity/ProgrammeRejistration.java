package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProgrammeRejistration implements SuperEntity {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "student_RId",referencedColumnName = "student_registerNumber")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "programme_Id",referencedColumnName = "programme_id")
    private Programme programme;
    private String rejisterDate;

    public ProgrammeRejistration() {
    }

    public ProgrammeRejistration(String id, Student student, Programme programme, String rejisterDate) {
        this.id = id;
        this.student = student;
        this.programme = programme;
        this.rejisterDate = rejisterDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRejisterDate() {
        return rejisterDate;
    }

    public void setRejisterDate(String rejisterDate) {
        this.rejisterDate = rejisterDate;
    }

    @Override
    public String toString() {
        return "ProgrammeRejistration{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", programme=" + programme +
                ", rejisterDate=" + rejisterDate +
                '}';
    }
}
