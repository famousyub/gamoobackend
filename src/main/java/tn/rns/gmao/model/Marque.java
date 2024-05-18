package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Marque")
public class Marque implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idMarque")
    private Integer idMarque;

    @Column(name = "nomMarque")
    private String nomMarque;

    public Integer getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Integer idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }
}
