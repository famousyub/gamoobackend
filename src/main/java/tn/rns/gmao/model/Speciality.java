package tn.rns.gmao.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Speciality")
public class Speciality  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSpec")
    private Integer idSpec;


    @Column(name = "nomSpec")
    private String nomSpec;

    public Integer getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public String getNomSpec() {
        return nomSpec;
    }

    public void setNomSpec(String nomSpec) {
        this.nomSpec = nomSpec;
    }
}
