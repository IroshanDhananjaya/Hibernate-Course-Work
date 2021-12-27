package entity;

import javax.persistence.*;

@Entity
public class ProgrammeRejistration implements SuperEntity {
    @Id
  private String id;
  private String date;
  @ManyToOne(fetch = FetchType.EAGER)
  private Student student;
  @ManyToOne(fetch = FetchType.EAGER)
  private Programme programme;

    public ProgrammeRejistration() {
    }

    public ProgrammeRejistration(String id, String date, Student student, Programme programme) {
        this.id = id;
        this.date = date;
        this.student = student;
        this.programme = programme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
