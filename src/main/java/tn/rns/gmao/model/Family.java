package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "Family")
public class Family {

    @Id
    @GeneratedValue
    @Column(name = "idFam")
    private Integer idFam;

    @Column(name = "nomFam")
    private String nomFam;

    public Integer getIdFam() {
        return idFam;
    }

    public void setIdFam(Integer idFam) {
        this.idFam = idFam;
    }

    public String getNomFam() {
        return nomFam;
    }

    public void setNomFam(String nomFam) {
        this.nomFam = nomFam;
    }
}

