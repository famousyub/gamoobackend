package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Intervention;
import tn.rns.gmao.model.InterventionEntity;

import java.util.Date;



@Builder
@Data

public class InterventionEntityDto {

    private Long  id;

    private String statutInter;

    private Date dateInter;

    private String descriptionIner;

    public static InterventionEntityDto fromEntity(InterventionEntity intervention) {
        if (intervention == null) {
            return null;
        }

        return InterventionEntityDto.builder()
                .id(intervention.getId())
                .statutInter(intervention.getStatutInter())
                .dateInter(intervention.getDateInter())
                . descriptionIner(intervention.getDescriptionIner())
                .build();
    }
    public static InterventionEntity toEntity(InterventionEntityDto dto) {
        if (dto == null) {
            return null;
        }
        InterventionEntity intervention = new InterventionEntity();
        intervention.setId(dto.getId());
        intervention.setStatutInter(dto.getStatutInter());
        intervention.setDateInter(dto.getDateInter());
        intervention.setDescriptionIner(dto.getDescriptionIner());
        return intervention;
    }
}
