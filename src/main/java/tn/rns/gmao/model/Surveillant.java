package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="Serveillant")
public class Surveillant extends Utilisateur{



    @OneToMany (mappedBy = "idDT")
    private List<RequestWork> RequestWork;


}
