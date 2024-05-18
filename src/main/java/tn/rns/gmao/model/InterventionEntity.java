package tn.rns.gmao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tn.rns.gmao.model.entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;



@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interventionentity")

public class InterventionEntity extends BaseEntity implements Serializable {

    @Column(name = "statutInter")
    private String statutInter;

    @Column(name = "dateInter")
    private Date dateInter;

    @Column(name = "descriptionIner")
    private String descriptionIner;

}
