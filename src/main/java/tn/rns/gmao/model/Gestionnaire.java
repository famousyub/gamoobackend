package tn.rns.gmao.model;


import javax.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name ="Gestionnaire")
public class Gestionnaire extends Utilisateur {


    @OneToMany (mappedBy = "idDT")
    private List<RequestWork> RequestWork;


}
