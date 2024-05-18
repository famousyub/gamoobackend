package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.model.SubFamily;

@Builder
@Data
public class SubFamilyDto {

    private Integer idSubFam;

    private String nomSubFam;

    private Family family;

    public static SubFamilyDto fromEntity(SubFamily subfamily) {
        if (subfamily == null) {
            return null;
        }
        return SubFamilyDto.builder()
                .idSubFam(subfamily.getIdSubFam())
                .nomSubFam(subfamily.getNomSubFam())
                .build();
    }
    public static SubFamily toEntity(SubFamilyDto subfamilyDto) {
        if (subfamilyDto == null) {
            return null;
        }
        SubFamily subfamily = new SubFamily();
        subfamily.setIdSubFam(subfamilyDto.getIdSubFam());
        subfamily.setNomSubFam(subfamilyDto.getNomSubFam());
        return subfamily;
    }

}
