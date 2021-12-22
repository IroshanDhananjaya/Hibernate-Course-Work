package dto;

import entity.Programme;
import entity.Student;


public class ProgrammeRejistrationDTO {
    private String id;
    private Student student;
    private Programme programme;
    private Student rejisterDate;

    public ProgrammeRejistrationDTO() {
    }

    public ProgrammeRejistrationDTO(String id, Student student, Programme programme, Student rejisterDate) {
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

    public Student getRejisterDate() {
        return rejisterDate;
    }

    public void setRejisterDate(Student rejisterDate) {
        this.rejisterDate = rejisterDate;
    }
}
