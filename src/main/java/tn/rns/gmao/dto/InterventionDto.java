package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Fournisseur;
import tn.rns.gmao.model.Intervention;


import java.util.Date;


@Builder
@Data
public class InterventionDto {

    private Integer idInter;

    private String statutInter;

    private Date dateInter;

    private String descriptionIner;

    public static InterventionDto fromEntity(Intervention intervention) {
        if (intervention == null) {
            return null;
        }

        return InterventionDto.builder()
                .idInter(intervention.getIdInter())
                .statutInter(intervention.getStatutInter())
                .dateInter(intervention.getDateInter())
                . descriptionIner(intervention.getDescriptionIner())
                .build();
    }
    public static Intervention toEntity(InterventionDto dto) {
        if (dto == null) {
            return null;
        }
       Intervention intervention = new Intervention();
        intervention.setIdInter(dto.getIdInter());
        intervention.setStatutInter(dto.getStatutInter());
        intervention.setDateInter(dto.getDateInter());
        intervention.setDescriptionIner(dto.getDescriptionIner());
        return intervention;
    }
}
