package dto;

import entity.Programme;
import entity.Student;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class ProgrammeRejistrationDTO {
     private String id;
     private String date;
     private StudentDTO studentDTO;
     private ProgrammeDTO programmeDTO;

    public ProgrammeRejistrationDTO() {
    }

    public ProgrammeRejistrationDTO(String id, String date, StudentDTO studentDTO, ProgrammeDTO programmeDTO) {
        this.id = id;
        this.date = date;
        this.studentDTO = studentDTO;
        this.programmeDTO= programmeDTO;
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

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudent(StudentDTO student) {
        this.studentDTO = student;
    }

    public ProgrammeDTO getProgramme() {
        return programmeDTO;
    }

    public void setProgramme(ProgrammeDTO programme) {
        this.programmeDTO = programme;
    }

    @Override
    public String toString() {
        return "ProgrammeRejistrationDTO{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", student=" + studentDTO +
                ", programme=" + programmeDTO +
                '}';
    }
}
