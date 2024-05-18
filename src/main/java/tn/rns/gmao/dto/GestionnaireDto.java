package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Gestionnaire;
import tn.rns.gmao.model.RequestWork;
import tn.rns.gmao.model.Surveillant;

import java.util.List;

@Builder
@Data
public class GestionnaireDto {

    private Integer id;

    private List<RequestWork> RequestWork;

    public static GestionnaireDto fromEntity(Gestionnaire gestionnaire) {
        if (gestionnaire == null) {
            return null;
        }
        return GestionnaireDto.builder()
                .id(gestionnaire.getId())
                .build();
    }
    public static Gestionnaire toEntity(GestionnaireDto dto) {
        if (dto == null) {
            return null;
        }
        Gestionnaire gestionnaire= new Gestionnaire();
        gestionnaire.setId(dto.getId());
        return gestionnaire;
    }
}
