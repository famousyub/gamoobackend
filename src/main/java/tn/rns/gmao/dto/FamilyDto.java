package tn.rns.gmao.dto;


import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Family;

@Builder
@Data
public class FamilyDto {

    private Integer idFam;

    private String nomFam;

    public static FamilyDto fromEntity(Family family) {
        if (family == null) {
            return null;
        }
        return FamilyDto.builder()
                .idFam(family.getIdFam())
                .nomFam(family.getNomFam())
                .build();
    }
    public static Family toEntity(FamilyDto familyDto) {
        if (familyDto == null) {
            return null;
        }
        Family family = new Family();
        family.setIdFam(familyDto.getIdFam());
        family.setNomFam(familyDto.getNomFam());
        return family;
    }
}
