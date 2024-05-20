package tn.rns.gmao.model;

import tn.rns.gmao.model.entities.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity

@Table
public class OGestionnaire  extends UserEntity {


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




}
