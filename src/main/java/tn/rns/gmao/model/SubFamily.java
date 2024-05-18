package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "SubFamily")
public class SubFamily {
    @Id
    @GeneratedValue
    @Column(name = "idSubFam")
    private Integer idSubFam;

    @Column(name = "nomSubFam")
    private String nomSubFam;

    @ManyToOne
    @JoinColumn(name = "idFam")
    private Family family;

    public Integer getIdSubFam() {
        return idSubFam;
    }

    public void setIdSubFam(Integer idSubFam) {
        this.idSubFam = idSubFam;
    }

    public String getNomSubFam() {
        return nomSubFam;
    }

    public void setNomSubFam(String nomSubFam) {
        this.nomSubFam = nomSubFam;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
