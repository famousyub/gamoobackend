package tn.rns.gmao.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue
    @Column(name = "idEq")
    private Integer idEq;

    @Column(name = "numserieEq")
    private String numserieEq ;

    @Column(name = "nomEq")
    private String nomEq;

    @Column(name = "dateachatEq")
    private Date dateachatEq;

    @Column(name = "statutEq")
    private String statutEq;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "mobility")
    private Boolean mobility;

    @Column(name = "type")
    private String type;

    @Column(name = "FonctionEq")
    private String FonctionEq;

    @ManyToOne
    @JoinColumn(name="idSpec")
    private Speciality Speciality;

    @ManyToOne
    @JoinColumn(name="idMarque")
    private Marque Marque;

    @ManyToOne
    @JoinColumn(name="idF")
    private Fournisseur Fournisseur ;

    @OneToMany (mappedBy = "id")
    private List <Technicien>Technicien;

    @OneToMany (mappedBy = "idDT")
    private List <RequestWork>RequestWork;

   /* @OneToMany(mappedBy =  "idInter")
    private List<Intervention> Intervention;*/

    @ManyToOne
    @JoinColumn(name="idSubFam")
    private SubFamily SubFamily ;


    public Integer getIdEq() {
        return idEq;
    }

    public void setIdEq(Integer idEq) {
        this.idEq = idEq;
    }

    public String getNumserieEq() {
        return numserieEq;
    }

    public void setNumserieEq(String numserieEq) {
        this.numserieEq = numserieEq;
    }

    public String getNomEq() {
        return nomEq;
    }

    public void setNomEq(String nomEq) {
        this.nomEq = nomEq;
    }

    public Date getDateachatEq() {
        return dateachatEq;
    }

    public void setDateachatEq(Date dateachatEq) {
        this.dateachatEq = dateachatEq;
    }

    public String getStatutEq() {
        return statutEq;
    }

    public void setStatutEq(String statutEq) {
        this.statutEq = statutEq;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Boolean getMobility() {
        return mobility;
    }

    public void setMobility(Boolean mobility) {
        this.mobility = mobility;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFonctionEq() {
        return FonctionEq;
    }

    public void setFonctionEq(String fonctionEq) {
        FonctionEq = fonctionEq;
    }

}
