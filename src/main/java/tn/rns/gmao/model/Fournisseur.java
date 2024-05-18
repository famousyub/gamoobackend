package tn.rns.gmao.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "Fournisseur")
public class Fournisseur implements Serializable {

    @Id
    @GeneratedValue
    @Column(name ="idF")
    private Integer idF;

    @Column(name ="nomF")
    private String nomF;

    @Column(name ="prenomF")
    private String prenomF;
    @Column(name ="adresseF")
    private String adresseF;

    @Column(name ="TelF")
    private String TelF;

    @Column(name ="EmailF")
    private String EmailF;

    @Column(name ="matriculeFiscale")
    private String matriculeFiscale;

    public Integer getIdF() {
        return idF;
    }

    public void setIdF(Integer idF) {
        this.idF = idF;
    }

    public String getNomF() {
        return nomF;
    }

    public void setNomF(String nomF) {
        this.nomF = nomF;
    }

    public String getPrenomF() {
        return prenomF;
    }

    public void setPrenomF(String prenomF) {
        this.prenomF = prenomF;
    }

    public String getAdresseF() {
        return adresseF;
    }

    public void setAdresseF(String adresseF) {
        this.adresseF = adresseF;
    }

    public String getTelF() {
        return TelF;
    }

    public void setTelF(String telF) {
        TelF = telF;
    }


    public String getEmailF() {
        return EmailF;
    }

    public void setEmailF(String emailF) {
        EmailF = emailF;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }
}
