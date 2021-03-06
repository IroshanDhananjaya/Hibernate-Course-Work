package entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Programme implements SuperEntity{
    @Id
    private String programme_id;
    private String programme_name;
    private String duration;
    private String fee;
    @OneToMany(mappedBy = "programme",cascade = CascadeType.ALL)
    private List<ProgrammeRejistration> details;


    public Programme() {
    }

    public Programme(String programme_id) {
        this.setProgramme_id(programme_id);
    }

    public Programme(String programme_id, String programme_name, String duration, String fee) {
        this.setProgramme_id(programme_id);
        this.setProgramme_name(programme_name);
        this.setDuration(duration);
        this.setFee(fee);
    }

    public String getProgramme_id() {
        return programme_id;
    }

    public void setProgramme_id(String programme_id) {
        this.programme_id = programme_id;
    }

    public String getProgramme_name() {
        return programme_name;
    }

    public void setProgramme_name(String programme_name) {
        this.programme_name = programme_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }


    @Override
    public String toString() {
        return "Programme{" +
                "programme_id='" + getProgramme_id() + '\'' +
                ", programme_name='" + getProgramme_name() + '\'' +
                ", duration='" + getDuration() + '\'' +
                ", fee='" + getFee() + '\'' +
                '}';
    }


    public List<ProgrammeRejistration> getDetails() {
        return details;
    }

    public void setDetails(List<ProgrammeRejistration> details) {
        this.details = details;
    }
}
