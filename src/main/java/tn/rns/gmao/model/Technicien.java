package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.*;
import tn.rns.gmao.model.entities.UserEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="Technicien")
public class Technicien extends Utilisateur {


    @Column(name = "SpetialityTech")
    private String SpetialityTech;

    @Column(name = "TelTech")
    private String TelTech;

    @OneToMany(mappedBy =  "idInter")
    private List<Intervention> Intervention;




    public String getTelTech() {
        return TelTech;
    }

    public void setTelTech(String telTech) {
        TelTech = telTech;
    }

}