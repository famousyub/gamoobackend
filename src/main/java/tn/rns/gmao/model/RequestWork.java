package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="DemandeTravaux")
public class RequestWork {

    @Id
    @GeneratedValue
    @Column(name ="idDT")
    private Integer idDT;

    @Column(name = "StatutDT")
    private String StatutDT;

    @Column(name = "dateDT")
    private Date dateDT;

    @Column(name = "descriptionDT")
    private String descriptionDT;

    @Column(name = "affectation")
    private String affectation;

    public Integer getIdDT() {
        return idDT;
    }

    public void setIdDT(Integer idDT) {
        this.idDT = idDT;
    }

    public String getStatutDT() {
        return StatutDT;
    }

    public void setStatutDT(String statutDT) {
        StatutDT = statutDT;
    }

    public Date getDateDT() {
        return dateDT;
    }

    public void setDateDT(Date dateDT) {
        this.dateDT = dateDT;
    }

    public String getDescriptionDT() {
        return descriptionDT;
    }

    public void setDescriptionDT(String descriptionDT) {
        this.descriptionDT = descriptionDT;
    }

    public String getAffectation() {
        return affectation;
    }

    public void setAffectation(String affectation) {
        this.affectation = affectation;
    }
}
