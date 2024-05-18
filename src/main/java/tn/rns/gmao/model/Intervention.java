package tn.rns.gmao.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "Intervention")
public class Intervention {

    @Id
    @GeneratedValue
    @Column(name = "idInter")
    private Integer idInter;

    @Column(name = "statutInter")
    private String statutInter;

    @Column(name = "dateInter")
    private Date dateInter;

    @Column(name = "descriptionIner")
    private String descriptionIner;

    public Integer getIdInter() {
        return idInter;
    }

    public void setIdInter(Integer idInter) {
        this.idInter = idInter;
    }

    public String getStatutInter() {
        return statutInter;
    }

    public void setStatutInter(String statutInter) {
        this.statutInter = statutInter;
    }

    public Date getDateInter() {
        return dateInter;
    }

    public void setDateInter(Date dateInter) {
        this.dateInter = dateInter;
    }

    public String getDescriptionIner() {
        return descriptionIner;
    }

    public void setDescriptionIner(String descriptionIner) {
        this.descriptionIner = descriptionIner;
    }
}
